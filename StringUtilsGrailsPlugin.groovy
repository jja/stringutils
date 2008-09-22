class StringUtilsGrailsPlugin {
    def version = 0.1
    def dependsOn = [:]

    // TODO Fill in these fields
    def author = "John Allison"
    def authorEmail = "jja@ucar.edu"
    def title = "Additional utility methods for java.lang.String"
    def description = '''\
Adds some utility methods for java.lang.String

excerpt(length)
 Returns a string no longer than length, with ... appended if the original string was longer.

excerpt() calls excerpt(255)
'''

    // URL to the plugin's documentation
    //def documentation = "http://grails.org/StringUtils+Plugin"
    def documentation = ""

    def doWithSpring = {
        // TODO Implement runtime spring config (optional)
    }
   
    def doWithApplicationContext = { applicationContext ->
        // TODO Implement post initialization spring config (optional)		
    }

    def doWithWebDescriptor = { xml ->
        // TODO Implement additions to web.xml (optional)
    }
	                                      
    def doWithDynamicMethods = { ctx ->
        String.metaClass.excerpt << { Integer length ->
            if (null == length) length=255
            if (length < 0) return null
            if (delegate.length() <= length) return delegate
            if (length < 3) return delegate.substring(0,length)
            def i
            for (i=length-3; i>0 && Character.isLetter(delegate.codePointAt(i)); i--) ;
            if (i==0) i=length-3;
            return delegate.substring(0,i) + '...'
        } << {-> delegate.excerpt(255)} // not really needed with length null check (?)
    }

    def onConfigChange = { event ->
        // TODO Implement code that is executed when the project configuration changes.
        // The event is the same as for 'onChange'.
    }
}
