package racingcar;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

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

    @DisplayName("RacingCar는 자동차 대수와 시도할 횟수가 같으면 같은 객체")
    @Test
    void 자동차경주_생성() {
        assertThat(RacingCar.create(3, 5)).isEqualTo(RacingCar.create(3, 5));
    }

    @DisplayName("자동차 대수가 0 이하일 경우 예외")
    @ParameterizedTest
    @ValueSource(ints = {0, -1, -5})
    void 자동차경주_자동차대수_0이하_예외(int input) {
        assertThatThrownBy(() -> {
            RacingCar.create(input, 5);
        }).hasMessageContaining("1 이상 입력해야 합니다.");
    }

    @DisplayName("시도횟수가 0 이하일 경우 예외")
    @ParameterizedTest
    @ValueSource(ints = {0, -1, -5})
    void 자동차경주_시도회수_0이하_예외(int input) {
        assertThatThrownBy(() -> {
            RacingCar.create(3, input);
        }).hasMessageContaining("1 이상 입력해야 합니다.");
    }



}
