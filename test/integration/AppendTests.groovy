class AppendTests extends GroovyTestCase {

    void testAppendSimple() {
        String given = "abc"
        String addtl = "def"
        String expected = "abcdef"

        assertEquals expected, given.append(addtl,1)
    }

    void testAppendSimpleShorthand() {
        String given = "abc"
        String addtl = "def"
        String expected = "abcdef"

        assertEquals expected, given.append(addtl)
    }

    void testAppendSimpleTwice() {
        String given = "abc"
        String addtl = "def"
        String expected = "abcdefdef"

        assertEquals expected, given.append(addtl,2)
    }

    void testAppendZeroTimes() {
        String given = "abc"
        String addtl = "def"
        String empty = ""

        assertEquals given, given.append(addtl,0)
        assertEquals given, given.append(empty,0)
        assertEquals empty, empty.append(addtl,0)
    }

    void testAppendNegativeTimes() {
        String given = "abc"
        String addtl = "def"
        String empty = ""

        assertEquals given, given.append(addtl,-1)
        assertEquals given, given.append(empty,-1)
        assertEquals empty, empty.append(addtl,-1)
    }

    void testAppendEmptyToShort() {
        String empty = ""
        String given = "abc"

        assertEquals given, given.append(empty)
        assertEquals given, given.append(empty,0)
        assertEquals given, given.append(empty,1)
        assertEquals given, given.append(empty,2)
        assertEquals given, given.append(empty,999)
    }

    void testAppendShortToEmpty() {
        String empty = ""
        String addtl = "def"
        String addtl2 = "defdef"

        assertEquals empty, empty.append(addtl,0)
        assertEquals addtl, empty.append(addtl,1)
        assertEquals addtl2, empty.append(addtl,2)
    }

    void testAppendEmptyToEmpty() {
        String empty = ""

        assertEquals empty, empty.append(empty)
        assertEquals empty, empty.append(empty,0)
        assertEquals empty, empty.append(empty,1)
        assertEquals empty, empty.append(empty,2)
        assertEquals empty, empty.append(empty,999)
    }

    void testAppendNullToEmpty() {
        String empty = ""

        assertEquals empty, empty.append(null)
        assertEquals empty, empty.append(null,0)
        assertEquals empty, empty.append(null,1)
        assertEquals empty, empty.append(null,2)
        assertEquals empty, empty.append(null,999)
    }

    void testAppendNullToShort() {
        String given = "abc"

        assertEquals given, given.append(null)
        assertEquals given, given.append(null,0)
        assertEquals given, given.append(null,1)
        assertEquals given, given.append(null,2)
        assertEquals given, given.append(null,999)
    }

    void testAppendNines() {
        String given = "a"
        String addtl = "9"
        String expected = new String(given)

        for (int i=0; i<999; i++)
            expected += addtl

        assertEquals expected, given.append(addtl,999)
    }

}
