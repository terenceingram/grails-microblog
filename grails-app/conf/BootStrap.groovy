class BootStrap {

    def init = { servletContext ->
		// Users
		def tez = new com.terenceingram.User(login:"tez", password:"123", name:"Terence Ingram")
		def pete = new com.terenceingram.User(login:"pete", password:"321", name:"Peter Ingram")
		
			
		// Posts
		def p1 = new com.terenceingram.Post(title:"Bushwalking at Booroomba Rocks",
		           content:"We headed out to Booroomba Rocks and did the 30 minute climb to the stop. Pretty tiring.",
		           published:true)


	   	def p2 = new com.terenceingram.Post(title:"Bike Riding along Lake Tuggies",
		           content:"We rode around Lake Tuggeranong and then headed to Maccas for a treat.",
		           published:true)
		
		def p3 = new com.terenceingram.Post(title:"Meeting up with the Ingrams",
			           content:"Our families got together for a wedding at the Botanic Gardens.",
			           published:true)
		
		tez.addToPosts(p1)
		tez.addToPosts(p2)
		tez.save()
		
		pete.addToPosts(p3)
		pete.save()
    }

    def destroy = {
    }
}
