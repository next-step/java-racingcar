package RacingGame;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RacingGameTest {

    @Test
    @DisplayName("Car가 자신이 존재한 위치를 잘 나타내는지 확인")
    public void checkCarIsAt(){
        Car racingCar = new Car();
        for (int i = 0 ; i <5 ; i++){
            racingCar.stopOrMove();
        }

        assertThat(racingCar.isAt()).isGreaterThan(-1);
        assertThat(racingCar.isAt()).isLessThan(5);
    }

//    @Test
//    @DisplayName("racing Car 가 잘 준비되는지 확인")
//    public void

}