package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step4.domain.Car;
import step4.domain.MovingStrategy;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @ParameterizedTest
    @DisplayName("자동차 랜덤값 4 이상 나올 경우 이동 확인")
    @ValueSource(ints = {4, 10, 500})
    public void moveCar(int randomValue) {
        Car car = new Car("name");
        car.move(randomValue);

        assertThat(car.isMoving()).isTrue();
    }

    @ParameterizedTest
    @DisplayName("자동차 랜덤값 3이하 나올 경우 이동 확인")
    @ValueSource(ints = {3, 1, 2})
    public void notMoveCar(int randomValue) {
        Car car = new Car("name");
        car.move(randomValue);

        assertThat(car.isMoving()).isFalse();
    }

    @Test
    @DisplayName("레거시 프로젝트 리팩토링 - 재정의")
    public void legacyMoveCar() {
        Car car = new Car("name") {
            @Override
            protected int getRandomNo() {
                return 4;
            }
        };
        car.move();
        assertThat(car.isMoving()).isTrue();
    }

    @Test
    @DisplayName("레거시 프로젝트 리팩토링 - 인터페이스")
    public void legacyNotMoveCar() {
        Car car = new Car("name");
        // 프로그래밍 상 자연스러운 DI 구조
        car.move(new MovingStrategy() {
            @Override
            public boolean movable() {
                return false;
            }
        });
        assertThat(car.isMoving()).isFalse();
    }

    @Test
    @DisplayName("레거시 프로젝트 리팩토링 - Lambda")
    public void legacyNotMoveCarLambda() {
        Car car = new Car("name");
        // 함수형 인터페이스, 메소드가 하나여만 한다.
        car.move(() -> false);
        assertThat(car.isMoving()).isFalse();
    }

}
