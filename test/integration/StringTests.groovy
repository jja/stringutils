class StringTests extends GroovyTestCase {

    void testExcerptEmpty() {
        String s = ""
        assertEquals s, s.excerpt()
        assertEquals s, s.excerpt(2)
        assertEquals s, s.excerpt(22)
        assertEquals s, s.excerpt(0)
        s = "foo bar"
        assertEquals s, s.excerpt(0)
    }

    void testExcerptLengthBoundary() {
        String s = ""
        assertNull s.excerpt(-1)

        s = "foo bar"
        assertEquals s, s.excerpt()
        assertEquals s, s.excerpt(42)
    }

    void testExcerpt() {
        String s = "foo bar bahz qux quxxle"
        assertEquals "foo bar...",s.excerpt(10)
        assertEquals "foo bar...",s.excerpt(12)
        assertEquals "fo...",s.excerpt(5)
    }

}
