package study1.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    @DisplayName("Car Test")
    void carTest(){
        // 무조건 전진
        Decision fixedDecision = new FixedMoveDecision(10);

        Car car = new Car(1);
        car.move(fixedDecision);
        car.move(fixedDecision);
        car.move(fixedDecision);
        car.move(fixedDecision);
        assertThat(car.getMoveDistance()).isEqualTo(5);

        // 전진 못 하는 자동차
        fixedDecision = new FixedMoveDecision(1);

        car = new Car(1);
        car.move(fixedDecision);
        car.move(fixedDecision);
        car.move(fixedDecision);
        car.move(fixedDecision);
        assertThat(car.getMoveDistance()).isEqualTo(1);
    }

    @Test
    @DisplayName("Race Result Test")
    void raceBoardTest(){
        int testNumber = 5;

        Car car = new Car(testNumber);
        assertThat(car.getMoveResult().length()).isEqualTo(testNumber);
    }
}
