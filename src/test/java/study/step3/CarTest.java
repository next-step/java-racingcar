package study.step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import step3.domain.Car;
import step3.domain.Movable;
import step3.domain.RacingGame;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private static final String CAR_NAMES = "pobi,crong,honux";
    private static final String DELIMITER = ",";
    private static final String TEST_NAME = "car";
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car(TEST_NAME);
    }

    @Test
    void createCarConstructorTest() {
        Car car = new Car("joo");
        Car newCar = new Car("joo");
        assertThat(car).isEqualTo(newCar);
    }

    @Test
    void carSplitTest() {
        String[] carNames = CAR_NAMES.split(DELIMITER);
        assertThat(carNames).hasSize(3);
        assertThat(carNames).contains("pobi", "crong", "honux");
    }

    @Test
    void moveConditionTest() {
        assertThat(this.car.movePosition(new Movable() {
            @Override
            public boolean isMove() {
                return false;
            }
        })).isEqualTo(0);

        assertThat(this.car.movePosition(new Movable() {
            @Override
            public boolean isMove() {
                return true;
            }
        })).isEqualTo(1);
    }
}
