package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private Name name = new Name("miz");

    @DisplayName("getPosition 을 통해 현재 위치를 받아 올 수 있다.")
    @Test
    void getCountTest() {
        Integer expectNow = 0;
        Car car = Car.createWithDefaultPosition(() -> false, name);

        assertThat(car.getPosition()).isEqualTo(Position.create(expectNow));
    }

    @DisplayName("MoveOrStop() strategy의 test의 결과가 true이면 position이 1 증가한다.")
    @Test
    void moveTest() {
        Integer expectNow = 1;

        Car car = Car.createWithDefaultPosition(() -> true, name);
        car = car.moveOrStop();

        assertThat(car.getPosition()).isEqualTo(Position.create(expectNow));
    }

    @DisplayName("MoveOrStop() strategy의 test의 결과가 false이면 position은 변하지 않는다.")
    @Test
    void stopTest() {
        Integer expectNow = 0;

        Car car = Car.createWithDefaultPosition(() -> false, name);
        car = car.moveOrStop();

        assertThat(car.getPosition()).isEqualTo(Position.create(expectNow));
    }

}