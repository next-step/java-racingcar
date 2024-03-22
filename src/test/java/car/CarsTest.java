package car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Cars;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    @DisplayName("3명인 경우 우승자 거리가 0인 경우 3명 공동 우승 확인 테스트")
    public void testGetZeroDistanceWinner() {
        Cars cars = new Cars(List.of(
                new Car("test0", 0),
                new Car("test1", 0),
                new Car("test2", 0)));
        List<Car> winners = cars.getWinnerCars();
        assertThat(winners).hasSize(3);
    }

    @Test
    @DisplayName("3명인 경우 1명의 우승자 구하는 확인 테스트")
    public void testGetWinner() {
        Cars cars = new Cars(List.of(
                new Car("test0", 0),
                new Car("test1", 1),
                new Car("test2", 2)));
        List<Car> winners = cars.getWinnerCars();
        assertThat(winners.get(0)).isEqualTo(new Car("test2", 2));
    }

    @Test
    @DisplayName("3명 중 2명이 같은 거리 간 경우 공동 우승자 확인 테스트")
    public void testGetSameDistanceWinner() {
        Cars cars = new Cars(List.of(
                new Car("test0", 1),
                new Car("test1", 3),
                new Car("test2", 3)));
        List<Car> winners = cars.getWinnerCars();
        assertThat(winners.size()).isEqualTo(2);
    }
    
}
