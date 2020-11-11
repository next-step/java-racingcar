package step4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingWinnerTest {
    RacingWinner racingWinner;
    List<Car> cars = new ArrayList<>();

    @BeforeEach
    public void before() {
        Car firstCar = new Car("annie");
        Car secondCar = new Car("happy");
        Car thirdCar = new Car("haa");

        IntStream.range(0, 3).forEach(i -> {
            firstCar.move(5);
            secondCar.move(3);
            thirdCar.move(5);
        });

        cars.add(firstCar);
        cars.add(secondCar);
        cars.add(thirdCar);

        racingWinner = new RacingWinner(cars);
    }

    @Test
    @DisplayName("우승자 2명인 경우 추출")
    public void 우승자_2명인_경우_추출() {
        assertThat(racingWinner.getWinners()).contains("annie", "haa");
    }

    @Test
    @DisplayName("단일 우승자 추출")
    public void 단일_우승자_추출() {
        Car fourthCar = new Car("silver");
        IntStream.range(0, 4).map(i -> 5).forEach(fourthCar::move);
        cars.add(fourthCar);
        racingWinner = new RacingWinner(cars);
        assertThat(racingWinner.getWinners()).isEqualTo("silver");
    }
}