package com.terenceingram

import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Post)
class PostTests {

    @Test
	void shouldPerformAddUpdateActions() {
		
		/*
		def user = new User("fred", "fred", "fred")
	    def post = new Post(title:"Family Bush Walk", content:"Pic of the family")
		user.addToPosts(post)
	    user.save()

	    def id = post.id
	    Post retrievedPost = Post.get(id)

	    assertEquals("Family Bush Walk", retrievedPost.title)

	    post.published = true
	    post.save()

	    retrievedPost = Post.get(id)
	    assertEquals(true, retrievedPost.published)
	*/
	}
	
	@Test
	void shouldEnsureThatTitleIsEntered() {
	  /*  Post post = new Post(title: "I have a title", content:"xxxx")
	    assertNull(post.save())

	    post.title = "I have a title"
	    assertNotNull(post.save())
	*/
	}
}
