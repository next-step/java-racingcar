package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class RacingCarTest {

    @DisplayName("자동차 경주 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"10 50"})
    public void racingTest(String input) {

        InputView.inputMethod(input);

        RacingCar.CarCount();
    }

    @DisplayName("자동차 경주 테스트2")
    @ParameterizedTest
    @ValueSource(strings = {"10 50"})
    public void racingTest2(String input){

    }
}