package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.exception.NameLengthException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @Test
    @DisplayName("랜덤 숫자가 9일 때 한칸 이동한다.")
    void move_GO() {
        Car car = createCar("onion",9);
        car.move();
        assertThat(1).isEqualTo(car.getPosition());
    }

    @Test
    @DisplayName("랜덤 숫자가 1일 때 STOP 이므로 이동하지 않는다.")
    void move_STOP() {
        Car car = createCar("rice",1);
        car.move();
        assertThat(0).isEqualTo(car.getPosition());
    }

    @Test
    @DisplayName("이름이 5자 이하이면 정상적으로 생성된다.")
    public void name_validation_5자_이하() {
        Car car = createCar("onion", 0);
        assertThat(car).isNotNull();
    }

    @Test
    @DisplayName("이름이 5자 초과이면 예외가 발생한다.")
    public void name_validation_5자_초과() {
        assertThatThrownBy(() -> createCar("oniononion", 0))
            .isInstanceOf(NameLengthException.class)
            .hasMessage("이름은 5자 이하만 가능합니다.");
    }

    private Car createCar(String name, int randomNumber) {
        return new Car(name) {
            @Override
            protected int generateRandomNumber() {
                return randomNumber;
            }
        };
    }
}

