package racing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;


public class CarTest {

    Car car;

    @BeforeEach
    void setUp() {
        car = new Car(new Player("jayce"), new CarPosition());
    }

    @DisplayName("이동 조건을 만족하면 position 값을 증가 시킨다.")
    @Test
    void moveCar() {
        //given
        MovingStrategy movingStrategy = () -> true;

        //when
        car.race(movingStrategy);

        //then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("이동 조건을 만족하지 않으면 position 값을 증가 시키지 않는다.")
    @Test
    void stopCar() {
        //given
        MovingStrategy movingStrategy = () -> false;

        //when
        car.race(movingStrategy);

        //then
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("두번 움직이고 한번 움직이지 못하는 조건일경우 자동차의 포지션은 2이다")
    @Test
    void carPositionTest() {
        //given
        MovingStrategy moveStrategy = () -> true;
        MovingStrategy stopStrategy = () -> false;

        //when
        car.race(moveStrategy);
        car.race(moveStrategy);
        car.race(stopStrategy);

        //then
        assertThat(car.getPosition()).isEqualTo(2);
    }

    @DisplayName("두번 움직이고 한번 움직이지 못하는 조건일경우 자동차 Postion Record는 1, 2, 2로 나와야한다")
    @Test
    void carPositionRecordTest() {
        //given
        MovingStrategy moveStrategy = () -> true;
        MovingStrategy stopStrategy = () -> false;

        //when
        car.race(moveStrategy);
        car.race(moveStrategy);
        car.race(stopStrategy);

        //then
        assertAll(
                () -> assertThat(car.getPositionRecord(0)).isEqualTo(1),
                () -> assertThat(car.getPositionRecord(1)).isEqualTo(2),
                () -> assertThat(car.getPositionRecord(2)).isEqualTo(2)
        );
    }
    
}
