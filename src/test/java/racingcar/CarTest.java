package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Record;
import racingcar.domain.movingstrategy.MovingStrategy;
import racingcar.domain.movingstrategy.RandomStrategy;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    class AlwaysMovableStrategy implements MovingStrategy {
        @Override
        public boolean isMovable() {
            return true;
        }
    }

    class NeverMovableStrategy implements MovingStrategy {
        @Override
        public boolean isMovable() {
            return false;
        }
    }

    @DisplayName("랜덤 입력값이 4 이상이면 전진한다.")
    @Test
    void moveTest() {
        //given
        Car car = new Car("name");
        MovingStrategy movingStrategy = new RandomStrategy();

        //when
        car.move(new AlwaysMovableStrategy());

        //then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("랜덤 입력값이 4보다 작으면 멈춘다.")
    @Test
    void stopTest() {
        //given
        Car car = new Car("name");
        int randomInt = 3;

        //when
        car.move(new NeverMovableStrategy());

        //then
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차 이름은 5자를 초과하는 경우 에러를 던진다.")
    void carNameTest() {
        //given
        String longName = "5자 초과하는 이름";

        //when & then
        Assertions.assertThatThrownBy(() -> new Car(longName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력된 이름이 유효하지 않습니다 [name: ");
    }

    @Test
    @DisplayName("자동차의 현재 기록을 정상적으로 생성한다.")
    void extractRecordTest() {

        //given
        Car car = new Car("name");
        car.move(new AlwaysMovableStrategy());

        //when
        Record record = car.extractRecord();

        //then
        Assertions.assertThat(record)
                .isNotNull()
                .extracting("name", "position", "attempt")
                .containsExactly("name", 1, 1);
    }
}