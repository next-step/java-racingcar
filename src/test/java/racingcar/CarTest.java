package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @DisplayName("이동거리만큼 이동할 수 있다.")
    @Test
    public void move_distance_togo() {
        String carName = "june";

        Car car = new Car(carName);

        car.move(new MovableRandomValueGenerator());
        car.move(new MovableRandomValueGenerator());
        car.move(new NonMovableRandomValueGenerator());

        assertThat(car.showNowPosition()).isEqualTo(2);
    }

    @DisplayName("숫자가 4보다 크먄 위치를 1칸 이동한다.")
    @Test
    public void move_NumberIsEqualOrGreaterThanFour_GoPositionForOne() {
        String carName = "june";
        RandomValueGenerator randomValue = new MovableRandomValueGenerator();
        Car car = new Car(carName);

        car.move(randomValue);
        assertThat(car.showNowPosition()).isEqualTo(1);
    }

    @DisplayName("숫자가 4보다 작으면 위치를 그대로 유지한다.")
    @Test
    public void move_NumberIsLessThanFour_KeepPosition() {
        String carName = "june";
        RandomValueGenerator randomValue = new NonMovableRandomValueGenerator();
        Car car = new Car(carName);

        car.move(randomValue);
        assertThat(car.showNowPosition()).isEqualTo(0);
    }

    @DisplayName("차 이름이 5글자 초과되면 안된다")
    @Test
    public void car_NameLongerThan5_ThrowException() {
        String carName = "hijune";

        assertThatThrownBy(() -> new Car(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }

}