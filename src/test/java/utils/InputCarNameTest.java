package utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.exception.CarNameAtLeastOneCommaWhenSplitException;
import utils.exception.CarNameExceedFiveCharacterException;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputCarNameTest {

    @Test
    @DisplayName("자동차 이름 입력 받는지")
    void input_car_name() {
        //given
        String inputCli = "abc,def,ghi";
        String[] expectedStr = {"abc", "def", "ghi"};

        //when
        System.setIn(new ByteArrayInputStream(inputCli.getBytes(StandardCharsets.UTF_8)));
        String[] carName = InputCarName.inCarName();

        //then
        assertThat(expectedStr).containsExactly(carName);
    }

    @Test
    @DisplayName("자동차 이름 입력시 5자리 초과로 입력시")
    void input_car_name_exceed_5_character() {
        //given
        System.setIn(new ByteArrayInputStream("eqeqwewqemqwewqqe,qwewqe".getBytes(StandardCharsets.UTF_8)));

        //when
        //then
        assertThatThrownBy(InputCarName::inCarName)
                .isInstanceOf(CarNameExceedFiveCharacterException.class)
                .hasMessageContaining("자동차 이름은 5글자 이하여야만 합니다.");
    }

    @Test
    @DisplayName("자동차 이름 입력시 (,) 미입력")
    void input_car_name_non_comma() {
        //given
        System.setIn(new ByteArrayInputStream("eqeqwewqemqwewqqeqwewqe".getBytes(StandardCharsets.UTF_8)));

        //when
        //then
        assertThatThrownBy(InputCarName::inCarName)
                .isInstanceOf(CarNameAtLeastOneCommaWhenSplitException.class)
                .hasMessageContaining("입력시 (,)를 최소 1번 이상 입력하셔야 합니다.");
    }

}
