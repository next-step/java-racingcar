package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class RacingCarTest {

    @DisplayName("사칙연산 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"10 50"})
    public void racing(String input) {

        InputView.inputMethod(input);

        RacingCar.CarCount();
    }

    @DisplayName("사칙연산 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"2 6"})
    public void stett(String input){
        String [] inputs = input.split(" ");
        System.out.println(inputs[0]);
        System.out.println(inputs[1]);
    }
}