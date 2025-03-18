package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import util.TestNumberGenerator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {
    @Test
    @DisplayName("초기 Car는 0이다.")
    public void initializeCar() {
        assertThat(new Car(0, "crong").getDistance()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차는 4이상의 값이 나오면 움직일 수 있다.")
    public void move() {
        Car car = new Car(0, "crong");
        car.move(new TestNumberGenerator(4));
        assertThat(car.getDistance()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차는 3이하의 값이 나오면 움직일 수 없다.")
    public void stop() {
        Car car = new Car(0, "crong");
        car.move(new TestNumberGenerator(3));
        assertThat(car.getDistance()).isEqualTo(0);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("자동차 이름으로 빈 값을 넣을 수 없다.")
    public void emptyCarName(String carName){
        assertThatThrownBy(() -> new Car(0, carName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름은 5자를 초과할 수 없다.")
    public void tooLongCarName(){
        assertThatThrownBy(()-> new Car(0, "abcdef"))
                .isInstanceOf(RuntimeException.class);
    }
}