package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarsTest {
    private List<Car> cars;

    @BeforeEach
    public void setUp() {
        this.cars = new ArrayList<>();

        cars.add(new Car("현진"));
        cars.add(new Car("진현"));

        cars.get(0).move(true);
        cars.get(0).move(true);
    }

    @Test
    public void selectWinnersTest() {
        int winnerLocation = selectWinnerLocation();

        List<Car> winners = cars.stream()
                .filter(car -> car.isSameLocation(winnerLocation))
                .collect(Collectors.toList());

        assertThat(winners.size()).isEqualTo(1);
    }

    private int selectWinnerLocation() {
        return this.cars.stream()
                .mapToInt(Car::getLocation)
                .max()
                .getAsInt()
                ;
    }
}
