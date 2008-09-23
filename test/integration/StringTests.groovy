class StringTests extends GroovyTestCase {

    void testExcerptEmpty() {
        String empty = ""
        assertEquals empty, empty.excerpt()
        assertEquals empty, empty.excerpt(2)
        assertEquals empty, empty.excerpt(22)
        assertEquals empty, empty.excerpt(0)
        String foobar = "foo bar"
        assertEquals empty, foobar.excerpt(0)
    }

    void testExcerptLengthBoundary() {
        String empty = ""
        assertNull empty.excerpt(-1)

        String foobar = "foo bar"
        assertEquals foobar, foobar.excerpt()
        assertEquals foobar, foobar.excerpt(42)
    }

    void testExcerpt() {
        String foobaretc = "foo bar bahz qux quxxle"
        assertEquals "foo bar...",foobaretc.excerpt(10)
        assertEquals "foo bar...",foobaretc.excerpt(12)
        assertEquals "fo...",foobaretc.excerpt(5)
    }

}
