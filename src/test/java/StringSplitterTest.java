import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringSplitterTest {

    private static final String DEFAULT_SEPARATOR = ",:";

    private void assertSeparatorAndInput(StringSplitter splitter, String expectedSeparator, String expectedInput) {
        assertEquals(expectedSeparator, splitter.getSeparator());
        assertEquals(expectedInput, splitter.getInputString());
    }

    @ParameterizedTest
    @ValueSource(strings = {"","1,2","1,2,3","1,2:3"})
    public void testFromWithoutMatch(String input) {
        StringSplitter splitter = StringSplitter.from(input);
        assertSeparatorAndInput(splitter, DEFAULT_SEPARATOR, input);
    }

    @ParameterizedTest
    @ValueSource(strings = "//;\n1;2;3")
    public void testFromWithMatch(String input) {
        StringSplitter splitter = StringSplitter.from(input);
        assertSeparatorAndInput(splitter, ";,:", "1;2;3");
    }
}
