class ChopTests extends GroovyTestCase {

    void testChopSimple() {
        String given = "abc"
        String expected = "ab"
        assertEquals expected, given.chop()
    }

    void testChopEmpty() {
        String empty = ""
        assertEquals empty, empty.chop()
    }

    void testChopShortString() {
        String given = "a"
        String empty = ""
        assertEquals empty, given.chop()
    }

}
