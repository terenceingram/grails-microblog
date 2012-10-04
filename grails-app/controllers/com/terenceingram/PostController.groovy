package com.terenceingram

import org.springframework.dao.DataIntegrityViolationException

class PostController {

    static allowedMethods = [save: "POST"]
	
	def beforeInterceptor = [action:this.&auth, except:["index", "list"]]

	  def auth() {
	    if (!session.user) {
	      redirect (controller:"user", action:"login")
	      return false
	    }
	  }

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [postInstanceList: Post.list(params), postInstanceTotal: Post.count()]
    }

    def create() {
        [postInstance: new Post(params)]
    }

    def save() {
		  
		  def postInstance = new Post(params)
		  postInstance.img = null
		  postInstance.imgType = null 
		
		  // Get the avatar file from the multi-part request
		  def f = request.getFile('img')
		
		  if (f != null) {
		  		
				// List of OK mime-types
			  def okcontents = ['image/png', 'image/jpeg', 'image/gif']
			  if (! okcontents.contains(f.getContentType())) {
			    flash.message = "Picture must be one of: ${okcontents}"
			    render (view:'create', model: [postInstance: postInstance])
			    return;
			  }

			   // Save the image and mime type
			   postInstance.img = f.getBytes()
			   postInstance.imgType = f.getContentType()
			   log.info("File uploaded: " + postInstance.imgType)
		  }
        
        if (!postInstance.save(flush: true)) {

			

            render(view: "create", model: [postInstance: postInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'post.label', default: 'Post'), postInstance.id])
        redirect(action: "list")
    }

    def delete(Long id) {
        def postInstance = Post.get(id)
        if (!postInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'post.label', default: 'Post'), id])
            redirect(action: "list")
            return
        }

        try {
            postInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'post.label', default: 'Post'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'post.label', default: 'Post'), id])
            redirect(action: "show", id: id)
        }
    }
}
