package study.racingCar;

import org.junit.jupiter.api.Test;
import study.StringAddCalculator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static study.racingCar.RacingCarGame.createCarList;
import static study.racingCar.RacingCarGame.nameSplit;

class RacingCarGameTest {

    @Test
    void carListTest() {
        String[] tester = {"aaa","bbb"};
        assertThat(createCarList(tester)).contains(new Car("aaa"));
    }

    @Test
    void splitErrorTest() {
        assertThatThrownBy(() -> nameSplit("asdfdfggh,asasdfdsafdad"))
                .isInstanceOf(IllegalArgumentException.class);
    }


}