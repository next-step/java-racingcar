package racingcar.controller;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.dto.input.CarNames;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static racingcar.common.Constant.SPLIT_LETTER;

class CarNamesTest {

    private final CarNames carNames = new CarNames("damas,bmw,benz");

    @ParameterizedTest
    @DisplayName("racingCarNames가 공백이거나 \"\" 이면, IllegalArgumentException을 던진다")
    @ValueSource(strings = {"", " "})
    void should_throw_Illegal_argument_exception_when_racing_car_names_is_blank(String carNames) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new CarNames(carNames))
                .withMessage("racing car name is wrong");
    }

    @Test
    @DisplayName("\",\"을 기준으로 문자열을 나눈다")
    void should_split_string_by_comma() {

        //Given & When
        List<String> split = carNames.split(SPLIT_LETTER);

        //Then
        assertThat(split).containsAll(Lists.newArrayList("damas", "bmw", "benz"));

    }

}
