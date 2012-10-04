package com.terenceingram



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(User)
class UserTests {

    @Test
	void shouldTestForUser() {
		User user = new User(login:"tez", password:"123", name:"Terence Ingram")
	    user.save()

	    def id = user.id
	    User retrievedUser = User.get(id)

	    assertEquals("Terence Ingram", retrievedUser.name)
	}
}
