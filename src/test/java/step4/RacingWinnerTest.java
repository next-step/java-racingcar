package step4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RacingWinnerTest {
    RacingWinner racingWinner;

    @BeforeEach
    public void before() {
        Car firstCar = new Car("annie");
        firstCar.setPosition(4);
        Car secondCar = new Car("happy");
        secondCar.setPosition(3);
        Car thirdCar = new Car("haa");
        thirdCar.setPosition(4);

        List<Car> cars = new ArrayList<>();
        cars.add(firstCar);
        cars.add(secondCar);
        cars.add(thirdCar);

        racingWinner = new RacingWinner(cars);
    }

    @Test
    @DisplayName("우승자 추출")
    public void 우승자_추출() {
        assertThat(racingWinner.getWinners()).contains("annie", "haa");
    }

    @ParameterizedTest
    @DisplayName("우승자 거리 추출")
    @ValueSource(ints = {4})
    public void 최장_거리_추출(int value){
        assertEquals(value, racingWinner.getPosition());
    }

}