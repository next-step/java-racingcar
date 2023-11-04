package study.racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

public class RoundTest {
    private Cars movingCars;
    private Cars stopedCars;

    @BeforeEach
    void init(){
        Car carAlwaysReturnAboveFour = new Car(new SuccessRandomGenratorStub(new Random()));
        Car carAlwaysReturnBelowFour = new Car(new FailRandomGenratorStub(new Random()));

        List<Car> movedCarList = new ArrayList<>(List.of(carAlwaysReturnAboveFour));
        movingCars = Cars.from(movedCarList);

        List<Car> stopedCarList = new ArrayList<>(List.of(carAlwaysReturnBelowFour));
        stopedCars = Cars.from(stopedCarList);
    }

    @DisplayName("라운드가 정상 진행")
    @Test
    void a(){
        Round round = new Round(movingCars);
        assertThatNoException().isThrownBy(round::race);
    }

}
