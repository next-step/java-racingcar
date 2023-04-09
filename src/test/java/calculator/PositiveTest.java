package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PositiveTest{
    /**
     * TODO
     * getNumber 없이 테스트가 가능하게.
     * 문자열이나 숫자 포장하면, 클래스 분리가 쉬워진다.
     */
    @Test
    void create(){
        Positive positive = new Positive("3");
        assertThat(positive.getNumber()).isEqualTo(3);
    }
}
