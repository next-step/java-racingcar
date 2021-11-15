package racingcar;

import org.junit.jupiter.api.Disabled;
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

    @Disabled
    @Test
    void 입력_자동차대수() {
        InputStream in = generateUserInput("3");
        System.setIn(in);
        InputView inputView = new InputView(new Scanner(System.in));
        assertThat(inputView.next("자동차 대수는 몇 대 인가요?")).isEqualTo(3);
    }

    @Disabled
    @Test
    void 입력_시도횟수() {
        InputStream in = generateUserInput("5");
        System.setIn(in);
        InputView inputView = new InputView(new Scanner(System.in));
        assertThat(inputView.next("시도할 횟수는 몇 회 인가요?")).isEqualTo(5);
    }

    @DisplayName("처음 자동차를 생성하면, 거리는 1이다.")
    @Test
    void 자동차_생성() {
        Car car = new Car(1);
        assertThat(car.getDistance()).isEqualTo(1);
    }

    @DisplayName("4이상이면 전진, 미만이면 멈춤")
    @Test
    void 전진또는멈춤() {
        Car car = new Car(1);
        assertThat(car.move(4)).isTrue();
        assertThat(car.move(1)).isFalse();
    }

    @Test
    void 자동차경주_생성() {
        RacingCar racingCar = RacingCar.create(3, 5);
        assertThat(racingCar.getCarCount()).isEqualTo(3);
        assertThat(racingCar.getRacingCount()).isEqualTo(5);
    }

}
