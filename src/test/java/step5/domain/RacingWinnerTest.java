package step5.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RacingWinnerTest {
    @Test
    @DisplayName("단일 우승자 추출")
    public void 단일_우승자_추출() {
        Car firstCar = new Car("hi");
        Car secondCar = new Car("happy");

        IntStream.range(0, 2).forEach(i -> {
            firstCar.move(6);
            secondCar.move(2);
        });

        List<Car> cars = new ArrayList<>();
        cars.add(firstCar);
        cars.add(secondCar);

        RacingWinner racingWinner = new RacingWinner(cars);

        assertEquals(racingWinner.getWinners(), "hi");
    }

    @Test
    @DisplayName("우승자 2명인 경우 추출")
    public void 우승자_2명인_경우_추출() {
        Car firstCar = new Car("annie");
        Car secondCar = new Car("happy");
        Car thirdCar = new Car("haa");

        IntStream.range(0, 3).forEach(i -> {
            firstCar.move(5);
            secondCar.move(3);
            thirdCar.move(5);
        });

        List<Car> cars = new ArrayList<>();
        cars.add(firstCar);
        cars.add(secondCar);
        cars.add(thirdCar);

        RacingWinner racingWinner = new RacingWinner(cars);
        assertThat(racingWinner.getWinners()).contains("annie", "haa");
    }
}