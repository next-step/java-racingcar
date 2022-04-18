package racing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CompetitionTest {
    private Competition competition;
    private Cars cars;

    @BeforeEach
    void 경주_완료() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("pobi", 3));
        carList.add(new Car("tobi", 5));
        carList.add(new Car("dog", 4));
        carList.add(new Car("sonny", 5));

        cars = new Cars(carList);
        competition = new Competition(cars);
    }

    @Test
    void 우승자_구하기() {
        List<Car> winningCars = Arrays.asList(
                new Car("tobi", 5)
                , new Car("sonny", 5)
        );
        assertThat(competition.getCarsWithMaxDistance(cars)).isEqualTo(winningCars);
    }
}