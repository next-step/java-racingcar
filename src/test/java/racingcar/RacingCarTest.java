package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RacingCarTest {

    @Test
    @DisplayName("[성공] 자동차가 4 이상의 값을 전달받는 경우 전진한다.")
    void 자동차_전진() {
        Car car = new Car(new CarMoveCondition());
        int distance = car.move(4);
        assertThat(distance).isEqualTo(1);
    }

    @Test
    @DisplayName("[성공] 자동차가 4 미만의 값을 전달받는 경우 전진하지 않는다.")
    void 자동차_정지() {
        Car car = new Car(new CarMoveCondition());
        int distance = car.move(3);
        assertThat(distance).isEqualTo(0);
    }

    @Test
    @DisplayName("[성공] 4 이상의 값을 전달받는 경우 전진 가능하다 판단한다.")
    void 자동차_전진_판단() {
        CarMoveCondition moveCondition = new CarMoveCondition();
        assertThat(moveCondition.isMovable(5)).isTrue();
    }

    @Test
    @DisplayName("[성공][경계값 테스트] 4를 전달받는 경우 전진 가능하다 판단한다.")
    void 자동차_전진_판단_4입력() {
        CarMoveCondition moveCondition = new CarMoveCondition();
        assertThat(moveCondition.isMovable(4)).isTrue();
    }

    @Test
    @DisplayName("[성공] 0~9 사이의 랜덤한 값을 생성한다.")
    void 랜덤값_생성() {
        assertThat(RandomValueGenerator.generate()).isBetween(0, 9);
    }

    @Test
    @DisplayName("[학습 테스트] AssertJ.isBetween() 경계값")
    void isBetween_메서드_경계값() {
        assertThat(0).isBetween(0, 9);
        assertThat(9).isBetween(0, 9);

        assertThatThrownBy(() -> {
            assertThat(-1).isBetween(0, 9);
        }).isInstanceOf(AssertionError.class);
        assertThatThrownBy(() -> {
            assertThat(10).isBetween(0, 9);
        }).isInstanceOf(AssertionError.class);
    }

    @Test
    @DisplayName("[성공] 자동차 3개를 가진 자동차 리스트를 생성한다.")
    void 자동차_리스트_생성_자동차3() {
        Cars cars = new Cars(3);
        assertThat(cars.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("[성공] 자동차 1개를 가진 자동차 리스트를 생성한다.")
    void 자동차_리스트_생성_자동차1() {
        Cars cars = new Cars(1);
        assertThat(cars.size()).isEqualTo(1);
    }

}
