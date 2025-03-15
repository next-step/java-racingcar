package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RaceTest {

    public static final int START = 0;

    @Test
    @DisplayName("사용자는 1회의 시도에 몇 대의 자동차를 사용할지 입력할 수 있다.")
    void inputCarNumbers() {
        String input = "3";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        String output = RacingCarGame.inputUsers();

        assertThat(output).isEqualTo(input);
    }

    @Test
    @DisplayName("사용자는 1회의 시도에 몇 번의 이동을 할 것인지 입력할 수 있다.")
    void inputMovement() {
        String input = "5";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        String output = RacingCarGame.inputUsers();
        assertThat(output).isEqualTo(input);
    }

    @Test
    @DisplayName("자동차는 전진할 수 있다.")
    void carCanMove() {
        Car car = new Car(START);
        car.move();
        assertThat(car.getDistance()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차는 멈출 수 있다.")
    void carCanStop() {
        Car car = new Car(START);
        car.stop();
        assertThat(car.getDistance()).isEqualTo(0);
    }
}
