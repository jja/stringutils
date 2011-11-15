class StringUtilsGrailsPlugin {
    def version = 0.2
    def dependsOn = [:]

    // TODO Fill in these fields
    def author = "John Allison"
    def authorEmail = "jja@sinequanon.net"
    def title = "Additional utility methods for String"
    def description = '''\
Adds some utility methods for String

excerpt(length)
 Returns a string no longer than length, with "..." appended if the original string was longer.
 Breaks the string at the last non-letter so the excerpt is readable.
 If length < 3 then "..." is not appended.

excerpt() calls excerpt(255)

chop()
 Returns a new string that has had the last character removed from the given string.
 Like perl's chop()

append(string,times)
 Returns a string consisting of the original string, appended by a new string the specified number of times.
 e.g. "foo".append("bar",2) == "foobarbar"

append(string)
 calls append(string,1) and is like StringBuilder.append()

isBlank()
 Returns a boolean indicating whether the trimmed version of the original string has 0 length

isNotBlank()
 Returns a boolean indicating whether the trimmed version of the original string has length > 0

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
            if (length <= 3) return delegate.substring(0,length)
            def i
            for (i=length-3; i>0 && Character.isLetter(delegate.codePointAt(i)); i--) ;
            if (i==0) i=length-3;
            return delegate.substring(0,i) + '...'
        } << {-> delegate.excerpt(255)} // not really needed with length null check (?)

        String.metaClass.chop << {
            try { return delegate.substring(0,delegate.length()-1) }
            catch (IndexOutOfBoundsException) { return '' }
        }

        String.metaClass.append << { String s, Integer n ->
            if (n<=0) return delegate
            if (!s?.length()) return delegate

            StringBuilder sb = new StringBuilder(n * s.length())
            n.times { sb.append(s) }
            return delegate + new String(sb)
        } << { String s -> delegate.append(s,1) }

        String.metaClass.isBlank << {
            return delegate.trim().length() == 0
        }

        String.metaClass.isNotBlank << {
            return delegate.trim().length() > 0
        }

    }

    def onConfigChange = { event ->
        // TODO Implement code that is executed when the project configuration changes.
        // The event is the same as for 'onChange'.
    }
}
