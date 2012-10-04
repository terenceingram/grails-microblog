package com.terenceingram

class User {

	static hasMany = [posts: Post]
	
    static constraints = {
	    login (unique:true)
	    password (password:true)
	    name(nullable:false )
	}

	String login
	String password
	String name

	String toString() {
	    name
	}
	
}
