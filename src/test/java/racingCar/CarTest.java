package racingCar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;


public class CarTest {
    @Test
    @DisplayName("자동차를 생성한다")
    void 자동차를_생성한다() {
        Car car = new Car(1L);
        assertThat(car.getDistance()).isZero();
    }

    @Test
    @DisplayName("자동차가 움직인다.")
    void 자동차가_움직인다() {
        Car car = new Car(1L);
        car.move();
        assertThat(car.getDistance()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차가 네번 움직인다.")
    void 자동차가_네번_움직인다() {
        Car car = new Car(1L);
        car.move();
        car.move();
        car.move();
        car.move();
        assertThat(car.getDistance()).isEqualTo(4);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:false","1:false","2:false","3:false","4:true","5:true","6:true","7:true","8:true","9:true"}, delimiter = ':')
    @DisplayName("canMove 메서드에 파라미터가 4 이상일때 true를 반환한다")
    void 전진_할_수_있는가(int number, Boolean expected) {
        Car car = new Car(1L);
        assertThat(car.canBeMove(number)).isEqualTo(expected);
    }

    @Test
    @DisplayName("자동차가 4 이상의 숫자를 받으면 움직인다.")
    void random_값을_반환한다() {
        Car car = new Car(1L);
        car.play(4);
        car.play(3);
        car.play(3);

        assertThat(car.getDistance()).isEqualTo(1);
        assertThat(car.getDistance()).isEqualTo(1);

    }
}
