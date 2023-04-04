package edu.nextstep.camp.study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
    
    @Test
    @DisplayName("String 의 split 기능 테스트")
    public void splitTest(){
        String numbersStr = "1,2";
        String[] numbersArr = numbersStr.split(",");

        assertThat(numbersArr)
            .containsExactly("1", "2");
    }

    @Test
    @DisplayName("String 의 substring 기능 테스트")
    public void substringTest(){
        String numbers = "(1,2)";
        int numbersLen = numbers.length();

        String noneBracketNumbers = numbers
            .substring(1, numbersLen)
            .substring(0, numbersLen-2);

        assertThat(noneBracketNumbers)
            .isEqualTo("1,2");
    }

    @Test
    @DisplayName("String 의 charAt 기능 Index out 테스트")
    public void failCharAtTest(){
        String abc = "abc";

        assertThatThrownBy(
            ()-> abc.charAt(3)
        ).isInstanceOf(StringIndexOutOfBoundsException.class)
            .hasMessage("String index out of range: 3");
    }
}
