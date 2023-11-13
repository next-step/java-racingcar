package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    private final String userName = "김동규";

    @DisplayName("자동차는 전진할 수 있다.")
    @Test
    void car_move_success() {
        // given
        final int FOUR = 4;
        Car car = new Car(userName);
        assertThat(car.getPosition().getValue()).isZero();

        // when
        car.move(FOUR);
        assertThat(car.getPosition().getValue()).isEqualTo(1);
    }

    @DisplayName("자동차는 정지할 수 있다.")
    @Test
    void car_stop_success() {
        // given
        Car car = new Car(userName);
        assertThat(car.getPosition().getValue()).isZero();

        // when
        car.move(0);
        assertThat(car.getPosition().getValue()).isZero();
    }

    @DisplayName("자동차는 0-9 사이의 값중 4이상의 값이 들어올 때 전진한다.")
    @ParameterizedTest
    @CsvSource(value = {"0:0", "1:0", "2:0", "3:0", "4:1", "5:1", "6:1", "7:1", "8:1", "9:1"}, delimiter = ':')
    void car_move_when_input_more_than_4(int input, int result) {
        // given
        Car car = new Car(userName);

        // when
        car.move(input);

        // then
        assertThat(car.getPosition().getValue())
                .isEqualTo(result);
    }

    @DisplayName("0~3 사이의 랜덤값 설정으로는 자동차가 항상 정지한다.")
    @Test
    void car_stop_when_random_bound_to_3() {
        // given
        Car car = new Car(userName);
        CarMoveStrategy carMoveStrategy = new CarMoveStrategy(3);

        // when
        int result = carMoveStrategy.getMoveSource();
        car.move(result);

        // then
        assertThat(car.getPosition().getValue()).isZero();
        assertThat(result).isLessThan(4);
    }

    @DisplayName("자동차는 이름을 가진다.")
    @Test
    void create_car_with_user_name() {
        // given
        final String userName = "김동규";

        // when
        Car car = new Car(userName);

        // then
        assertThat(car.getCarName()).isEqualTo(userName);
    }

    @DisplayName("자동차의 이름은 5자를 초과할 수 없다. 초과시, IllegalArgumentException 을 발생시킨다.")
    @Test
    void create_car_with_long_user_name() {
        // given
        final String userName = "여섯글자이름";

        // then
        assertThatThrownBy(() -> new Car(userName)).isInstanceOf(IllegalArgumentException.class);
    }

}
