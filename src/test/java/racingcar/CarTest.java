package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import racingcar.strategy.MovableStrategy;
import racingcar.strategy.RandomMovableStrategy;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

class CarTest {

    @Test
    @DisplayName("자동차의 시작 위치는 0")
    void init() {
        assertThat(new Car(new RandomMovableStrategy()).getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("이동 한번 성공 시 position이 1이다")
    void one_move(){
        Car car = new Car(new MovableStrategy() {
            @Override
            public boolean canMove() {
                return true;
            }
        });
        car.move();

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("이동 실패 시 position이 0이다")
    void zero_move(){
        Car car = new Car(new MovableStrategy() {
            @Override
            public boolean canMove() {
                return false;
            }
        });
        car.move();

        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("5번 이동 성공 시 position이 5이다")
    void five_move(){
        Car car = new Car(new MovableStrategy() {
            @Override
            public boolean canMove() {
                return true;
            }
        });
        for (int i = 0; i < 5; i++) {
            car.move();
        }

        assertThat(car.getPosition()).isEqualTo(5);
    }
}