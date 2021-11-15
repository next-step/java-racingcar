package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingCarTest {

    private static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @Test
    void 입력_자동차대수() {
        InputStream in = generateUserInput("3");
        System.setIn(in);
        InputView inputView = new InputView(new Scanner(System.in));
        assertThat(inputView.input("자동차 대수는 몇 대 인가요?")).isEqualTo(3);
    }

    @Test
    void 입력_시도횟수() {
        InputStream in = generateUserInput("5");
        System.setIn(in);
        InputView inputView = new InputView(new Scanner(System.in));
        assertThat(inputView.input("시도할 횟수는 몇 회 인가요?")).isEqualTo(5);
    }

    @DisplayName("처음 자동차를 생성하면, 거리는 0이다.")
    @Test
    void 자동차_생성() {
        Car car = new Car(1);
        assertThat(car.getDistance()).isEqualTo(0);
    }

    @Test
    void 전진또는멈춤() {
        Car car = new Car(1);
        assertThat(car.move(4)).isTrue();
        assertThat(car.move(1)).isFalse();
    }

    @Test
    void 출력_자동차상태() {

    }

}
