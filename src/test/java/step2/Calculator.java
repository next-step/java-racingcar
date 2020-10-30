package step2;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class Calculator {

    static final char plus = '+';
    static final char minus = '-';
    static final char div = '/';
    static final char mul = '+';
    String[] value = "2 + 3 * 4 / 2".split(" ");


    @DisplayName("계산")
    @Test
    public void main(){
        assertThat(value).contains("2");
    }


    @DisplayName("더하기")
    public void addition () {
    }

    @DisplayName("빼기")
    public void subtraction () {
    }

    @DisplayName("곱하기")
    public void multiplication () {
    }

    @DisplayName("나누기")
    public void division () {
    }

}
