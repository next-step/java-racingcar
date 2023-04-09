package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class ParserTest {
    @ParameterizedTest(name = "커스텀 구분자 구분 {1}")
    @CsvSource(value = {"'//;\n1;2;3':;:1;2;3", "'//#\n1#3#4':#:1#3#4", "'//@\n2@4@5':@:2@4@5"}, delimiter = ':')
    void findCustomDelimiter(String text, String delimiter, String output){
        Parser parser = new Parser(text);

        assertThat(parser.findDelimiter()).isEqualTo(delimiter);
        assertThat(parser.findText()).isEqualTo(output);
    }
}
