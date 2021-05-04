package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsFindWinnersTest {

    @Test
    @DisplayName("우승한 차가 한 대일 경우")
    void find_winners_case_when_number_of_winner_is_one() {
        String winner = "bmw";
        String notWinner1 = "audi";
        String notWinner2 = "benz";
        Car bmw = makeCar(winner, 3);
        Car audi = makeCar(notWinner1, 2);
        Car benz = makeCar(notWinner2, 1);

        Cars cars = makeCars(bmw, audi, benz);
        Winners winners = cars.findWinners();

        assertThat(winners.toString()).isEqualTo(winner);
        assertThat(winners.toString()).isNotEqualTo(notWinner1);
        assertThat(winners.toString()).isNotEqualTo(notWinner2);
        assertThat(winners.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("우승한 차가 두 대일 경우")
    void find_winners_case_when_number_of_winner_are_two() {
        String winner1 = "bmw";
        String winner2 = "audi";
        String notWinner = "benz";
        Car bmw = makeCar(winner1, 3);
        Car audi = makeCar(winner2, 3);
        Car benz = makeCar(notWinner, 1);

        Cars cars = makeCars(bmw, audi, benz);
        Winners winners = cars.findWinners();

        assertThat(winners.toString()).contains(winner1);
        assertThat(winners.toString()).contains(winner2);
        assertThat(winners.toString()).doesNotContain(notWinner);
        assertThat(winners.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("경주한 차가 모두 우승인 경우")
    void find_winners_case_when_number_of_winner_are_all() {
        String winner1 = "bmw";
        String winner2 = "audi";
        String winner3 = "benz";
        Car bmw = makeCar(winner1, 3);
        Car audi = makeCar(winner2, 3);
        Car benz = makeCar(winner3, 3);

        Cars cars = makeCars(bmw, audi, benz);
        Winners winners = cars.findWinners();

        assertThat(winners.toString()).contains(winner1);
        assertThat(winners.toString()).contains(winner2);
        assertThat(winners.toString()).contains(winner3);
        assertThat(winners.size()).isEqualTo(3);
    }

    private Cars makeCars(Car... cars) {
        List<Car> carList = new ArrayList<>(Arrays.asList(cars));
        return new Cars(carList);
    }

    private Car makeCar(String carName, int numberOfMoves) {
        Car car = Car.of(carName, () -> true);
        for (int i = 0; i < numberOfMoves; i++) {
            car.move();
        }
        return car;
    }
}
