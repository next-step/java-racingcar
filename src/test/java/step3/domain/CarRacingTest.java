package step3.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarRacingTest {

    CarRacing carRacing;

    @BeforeEach
    void setUp(){
        carRacing = new CarRacing("nio,hoon,mit,bill,ravi", 5);
    }

    @Test
    @DisplayName("totalTries 만큼 이동시도를 하면 경기는 종료된다")
    void isFinish(){
        carRacing.tryMovingAllCars();
        carRacing.tryMovingAllCars();
        carRacing.tryMovingAllCars();
        carRacing.tryMovingAllCars();
        carRacing.tryMovingAllCars();

        assertThat(carRacing.isFinish()).isTrue();
    }

    @Test
    @DisplayName("totalTries 만큼 이동시도를 하면 경기는 종료된다")
    void isNotFinish(){
        carRacing.tryMovingAllCars();
        carRacing.tryMovingAllCars();
        carRacing.tryMovingAllCars();

        assertThat(carRacing.isFinish()).isFalse();
    }



}