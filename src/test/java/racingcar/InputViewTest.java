package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;

class InputViewTest {

    @ParameterizedTest
    @ValueSource(strings = {"3\n5\n"})
    public void 입력값을_통한_RacingCar_생성(String input) {
        generateUserInput(input);
        RacingCar racingCarInput = InputView.getRacingCarInput();
        Assertions.assertThat(racingCarInput).isEqualTo(new RacingCar(3, 5));
    }

    public static void generateUserInput(String input) {
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }
}