class ExcerptTests extends GroovyTestCase {

    void testExcerptEmpty() {
        String empty = ""
        assertEquals empty, empty.excerpt()
        assertEquals empty, empty.excerpt(2)
        assertEquals empty, empty.excerpt(22)
        assertEquals empty, empty.excerpt(0)

    }

    void testExcerptLengthBoundary() {
        String empty = ""
        assertNull empty.excerpt(-1)

        String foobar = "foo bar"
        assertNull foobar.excerpt(-1)
    }

    void testExcerptLengthLonger() {
        String foobar = "foo bar"
        assertEquals foobar, foobar.excerpt()
        assertEquals foobar, foobar.excerpt(42)
    }

    void testExcerptLengthShorter() {
        String foobaretc = "foo bar bahz qux quxxle"
        assertEquals "f...",foobaretc.excerpt(4)
        assertEquals "fo...",foobaretc.excerpt(5)
        assertEquals "foo...",foobaretc.excerpt(6)
        assertEquals "foo...",foobaretc.excerpt(7)
        assertEquals "foo...",foobaretc.excerpt(8)
        assertEquals "foo bar...",foobaretc.excerpt(10)
        assertEquals "foo bar...",foobaretc.excerpt(12)
    }

    void testExcerptReallyShortLength() {
        String foobar = "foo bar"

        assertEquals "", foobar.excerpt(0)
        assertEquals "f",foobar.excerpt(1)
        assertEquals "fo",foobar.excerpt(2)
        assertEquals "foo",foobar.excerpt(3)
    }

    void testExcerptShortString() {
        String foobar = "f"

        assertEquals "f",foobar.excerpt(1)
        assertEquals "f",foobar.excerpt(2)
        assertEquals "f",foobar.excerpt(3)
        assertEquals "f",foobar.excerpt(4)
        assertEquals "f",foobar.excerpt(57)
        assertEquals "f",foobar.excerpt()
    }

}
