package strcalculator.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringProcessorTest {


    @Test
    @DisplayName("공백 or null 만 들어왔을때 오류 확인")
    public void checkNullOrSpace() {
        assertThrows(IllegalArgumentException.class, () -> new StringProcessor(" "));
    }

    @Test
    @DisplayName("사칙연산 제외한 숫자만 남는지 확인")
    public void inputParseNumber(){
        StringProcessor stringProcessor = new StringProcessor("1+   2+  3");
        String[] strings = stringProcessor.parseInputNumber();
        Arrays.stream(strings).allMatch((s)->s.matches("[0-9]+"));

    }

    @Test
    @DisplayName("숫자를 제외한 사칙연산만 남는지 확인")
    public void inputParseOperands(){
        StringProcessor stringProcessor = new StringProcessor("1+   2+  3");
        String[] strings = stringProcessor.parseInputNumber();
        Arrays.stream(strings).allMatch((s)->s.matches("[+\\-*/]"));
    }
}
