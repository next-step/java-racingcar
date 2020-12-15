package study.racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.racingcar.domain.Car;
import study.racingcar.domain.Cars;
import study.racingcar.domain.Position;
import study.racingcar.dto.WinnerResults;

class CarsTest {

    @Test
    @DisplayName("Cars 클래스의 moveAll 전진 테스트")
    public void moveAll_test() throws Exception {
        //Given
        Cars cars = new Cars(Arrays.asList(new Car("pobi"), new Car("cron"), new Car("jane")));

        //When
        cars.moveAll(() -> true);

        //Then
        List<Car> results = cars.getResult();

        results.forEach(car ->
            assertThat(car.getPosition()).isEqualTo(new Position(1)));

    }

    @Test
    @DisplayName("Cars 클래스의 moveAll 멈춤 테스트")
    public void moveAll_stop_test() throws Exception {
        //Given
        Cars cars = new Cars(Arrays.asList(new Car("pobi"), new Car("cron"), new Car("jane")));

        //When
        cars.moveAll(() -> false);

        //Then
        List<Car> results = cars.getResult();

        results.forEach(car ->
            assertThat(car.getPosition()).isEqualTo(new Position(0)));

    }

    @Test
    @DisplayName("Cars 클래스의 findWinner  테스트")
    public void findWinner_test() throws Exception {
        //Given
        Car pobi = new Car("pobi");
        pobi.move(() -> true);
        pobi.move(() -> true);
        Cars cars = new Cars(Arrays.asList(pobi, new Car("cron"), new Car("jane")));

        //When
        WinnerResults winners = cars.findWinners();

        //Then
        String winnerNames = winners.getWinnerNames();

        assertThat(winnerNames).contains(pobi.getName().getName());
    }

    @Test
    @DisplayName("Cars 클래스의 복수 findWinner  테스트")
    public void findWinner_multiple_winner_test() throws Exception {
        //Given
        Car pobi = new Car("pobi");
        pobi.move(() -> true);
        pobi.move(() -> true);
        Car cron = new Car("cron");
        cron.move(() -> true);
        cron.move(() -> true);
        Cars cars = new Cars(Arrays.asList(pobi, cron, new Car("jane")));

        //When
        WinnerResults winners = cars.findWinners();

        //Then
        String winnerNames = winners.getWinnerNames();

        assertThat(winnerNames).contains(pobi.getName().getName());
        assertThat(winnerNames).contains(cron.getName().getName());
    }

}
