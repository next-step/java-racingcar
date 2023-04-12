package racing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {
    @ParameterizedTest(name = "랜덤값이 {0}일 때 자동차는 정지한다")
    @ValueSource(ints = {0, 1, 2, 3})
    void 자동차_정지(int randomNumber) {
        Car car = new Car(0, 5);

        car.move(randomNumber);
        assertThat(car.position()).isZero();
    }

    @ParameterizedTest(name = "랜덤값이 {0}일 때 자동차는 이동한다")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void 자동차_이동(int randomNumber) {
        Car car = new Car(0, 5);

        car.move(randomNumber);
        assertThat(car.position()).isEqualTo(1);
    }

    @ParameterizedTest(name = "랜덤값이 경계를 벗어날때 에러를 던진다")
    @ValueSource(ints = {-1, 10})
    void 자동차_이동_에러(int randomNumber) {
        Car car = new Car(0, 5);

        assertThatThrownBy(() -> car.move(randomNumber))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("랜덤값 경계를 벗어났습니다.");
    }

    @Test
    void 모든_자동차들은_이동횟수만큼_이동한다() {
        Cars movedCars = new Cars(3, 3).move();
        movedCars.values()
                .forEach(car -> {
                    assertThat(car.position()).isBetween(0, 3);
                });
    }
}
