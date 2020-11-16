package step3.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarRacingTest {

    @Test
    @DisplayName("total 만큼 try 하면 경기는 끝난다")
    void isFinish(){
        CarRacing carRacing = new CarRacing("nio,hoon,mit,bill,ravi", 5);

        carRacing.tryMovingAllCars();
        carRacing.tryMovingAllCars();
        carRacing.tryMovingAllCars();
        carRacing.tryMovingAllCars();
        carRacing.tryMovingAllCars();

        assertThat(carRacing.isInCarRacing()).isFalse();
    }

    @Test
    @DisplayName("try 가 total 보다 작으면 경기상태는 진행중이다")
    void isNotFinish(){
        CarRacing carRacing = new CarRacing("nio,hoon,mit,bill,ravi", 5);

        carRacing.tryMovingAllCars();
        carRacing.tryMovingAllCars();
        carRacing.tryMovingAllCars();

        assertThat(carRacing.isInCarRacing()).isTrue();
    }



}