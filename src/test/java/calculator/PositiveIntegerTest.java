package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class PositiveIntegerTest {

    @DisplayName("클래스 객체 생성")
    @Test
    void create() {
        //given
        PositiveInteger positiveInteger = new PositiveInteger("3");

        //when
        //then
        assertThat(positiveInteger.getNumber()).isEqualTo(3);
    }

}