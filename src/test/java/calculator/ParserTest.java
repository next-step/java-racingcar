package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParserTest {

    private Parser parser;

    @BeforeEach
    void setUp(){
        this.parser = new Parser();
    }

    @ParameterizedTest
    @CsvSource(value = {"1+2:1,+,2", "1+3-2:1,+,3,-,2", "3*4:3,*,4", "3*5/6:3,*,5,/,6"}, delimiter = ':')
    public void canParseExpression(String input, String expected){
        List<String> expectedList = Arrays.stream(
                expected.split(","))
                .collect(Collectors.toList());
        assertEquals(parser.parseExpression(input), expectedList);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1:1:true",
            "1:-:false",
            "-:1:false",
            "-:-:false"}, delimiter = ':')
    public void canTellShouldMerge(String input, char character, boolean expected){
        assertEquals(parser.shouldMerge(input, character), expected);
    }

}