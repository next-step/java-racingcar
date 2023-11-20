package study.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {
    @Test
    @DisplayName("차를 움직이는 경우 position이 증가된다.")
    void movingCarTest() {
        //given
        Car car = new Car("A", 3);
        //when
        car.moving(4);
        car.moving(3);
        car.moving(5);

        //then
        assertThat(car.getPosition()).isEqualTo(5);
    }

    @Test
    @DisplayName("position이 같으면 true를 출력한다. ")
    void matchPositionTest() {
        Car car = new Car("a", 3);
        assertThat(car.matchPosition(3)).isTrue();
    }

    @Test
    @DisplayName("테스트하기 힘든 부분을 분리해 테스트 가능하도록 구조화한다. ")
    void carRandomTest() {
        Car car = new Car("a") {
            @Override
            protected int getRandomNumber() {
                return 4;
            }
        };

        car.moving();
        assertThat(car.matchPosition(1)).isTrue();
    }
}
