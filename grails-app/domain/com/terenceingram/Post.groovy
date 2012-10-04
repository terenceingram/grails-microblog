package com.terenceingram

class Post {

		static belongsTo = [user: User]

	    static constraints = {
		        title (nullable:false, blank:false, length:1..150)
		        content (nullable:false, blank:false)
		        lastUpdated (nullable:true)
				img (nullable:true)
				imgType (nullable:true)
		}

		String title
		String content
		Date lastUpdated
		byte[] img
		String imgType
	
}
