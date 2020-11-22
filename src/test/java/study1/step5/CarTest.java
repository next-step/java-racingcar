package study1.step5;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    void carCreateTest(){
        Car car = new Car("racer", 1);
        assertThat(car).isEqualTo(new Car("racer", 1));
    }

    @Test
    void carMoveTest(){
        Decision fixedDecision = new FixedMoveDecision(10);

        int initialNumber = 1;
        Car car = new Car("test", initialNumber);

        int testCnt = 5;

        for(int i = 0; i < testCnt; i++){
            car.move(fixedDecision);
        }
        assertThat(car.distance).isEqualTo(initialNumber+testCnt);
    }

    @Test
    void isBestRacerTest(){
        int initialNumber = 1;
        int highestScore = 5;
        Decision fixedDecision = new FixedMoveDecision(10);

        Car car = new Car("test", initialNumber);

        assertThat(car.isBestRacer(highestScore)).isEqualTo(false);

        for(int i = 0; i < (highestScore-initialNumber); i++){
            car.move(fixedDecision);
        }

        assertThat(car.isBestRacer(highestScore)).isEqualTo(true);
    }
}
