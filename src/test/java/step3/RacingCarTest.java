package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.InputMismatchException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class RacingCarTest {

    void makeTestInput(String input) {
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @DisplayName("UI 입력 테스트")
    @Test
    void inputViewTest() {
        makeTestInput("3\n5\n"); // 3대의 자동차와 5회의 경주 입력

        RacingCar racingCar = RacingCarFactory.createRacingCarWithInputView();
        assertThat(racingCar.getNumberOfCar()).isEqualTo(3);
        assertThat(racingCar.getNumberOfRace()).isEqualTo(5);
    }

    @DisplayName("UI 입력 오류 테스트")
    @Test
    void inputViewErrorTest() {
        makeTestInput("가\n나\n");

        assertThatThrownBy(() ->
                RacingCarFactory.createRacingCarWithInputView())
                .isInstanceOf(InputMismatchException.class)
                .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("랜덤 난수 발생 테스트")
    @Test
    void randomNumberTest() {
        makeTestInput("3\n5\n");

        RacingCar racingCar = RacingCarFactory.createRacingCarWithInputView();
        racingCar.generateRandomNumber();

        assertThat(racingCar.getCar(0)).isBetween(0, 9);
        assertThat(racingCar.getCar(1)).isBetween(0, 9);
        assertThat(racingCar.getCar(2)).isBetween(0, 9);
    }
}
