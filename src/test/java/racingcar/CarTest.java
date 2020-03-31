package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.car.AlwaysNineEngine;
import racingcar.car.Car;
import racingcar.car.Engine;
import racingcar.car.RandomEngine;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("Car 의 이동 여부를 결정지을 AlwaysNineEngine 객체는 항상 9를 반환한다")
    @Test
    void generateNumberNine() {
        Engine engine = new AlwaysNineEngine();

        assertThat(engine.generateNumber()).isEqualTo(9);
        assertThat(engine.generateNumber()).isEqualTo(9);
        assertThat(engine.generateNumber()).isEqualTo(9);
    }

    @DisplayName("Engine 구현체에서 최근에 생성한 값을 테스트한다")
    @Test
    void generateNumberTest() {
        Engine nineEngine = new AlwaysNineEngine();
        Engine randomEngine = new RandomEngine();

        assertThat(nineEngine.generateNumber()).isEqualTo(9);
        assertThat(randomEngine.generateNumber()).isEqualTo(randomEngine.getPreviousNumber());
    }

    @DisplayName("한대의 Car가 random 한 값에 따라 정상적으로 이동하는지 확인한다")
    @Test
    void singleCarRace() {
        Engine engine = new RandomEngine();
        Car car = new Car("pobi", engine);

        int record = 0;
        car.move();
        if(engine.isMoved()) {
            record++;
        }
        car.move();
        if(engine.isMoved()) {
            record++;
        }
        car.move();
        if(engine.isMoved()) {
            record++;
        }
        car.move();
        if(engine.isMoved()) {
            record++;
        }
        car.move();
        if(engine.isMoved()) {
            record++;
        }

        assertThat(car.getRecord().get(4)).isEqualTo(record);
    }
}