package carracing.application;

import static org.assertj.core.api.Assertions.assertThat;

import carracing.domain.Car;
import carracing.domain.RaceResult;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarRacingTest {

    @Test
    @DisplayName("게임을 시작할 자동차를 원하는 갯수만큼 생성할 수 있다.")
    void makeCarTest() {

        // given
        String[] names = {"1", "2", "3"};
        CarRacing carRacing = new CarRacing();

        // when
        List<Car> result = carRacing.makeCars(names);

        // then
        assertThat(result.size()).isEqualTo(names.length);
    }

    @Test
    @DisplayName("게임이 시작하면 지정된 회수만큼 게임이 진행된다.")
    void raceTest() {

        // given
        String inputName = "test1,test2,test3";
        int raceCount = 3;
        CarRacing carRacing = new CarRacing();

        // when
        List<RaceResult> results = carRacing.race(inputName, raceCount);

        // then
        assertThat(results.size()).isEqualTo(raceCount);
    }

    @Test
    @DisplayName("자동차 경주 결과의 우승자 리스트를 반환할 수 있어야 한다.")
    void findRaceWinnerTest() {

        // given
        Car winner = new Car("우승자");
        winner.forward();
        List<Car> cars = Arrays.asList(
            new Car("자동차1"),
            new Car("자동차2"),
            new Car("자동차3"),
            winner
        );
        CarRacing carRacing = new CarRacing();

        // when
        List<Car> winners = carRacing.findWinners(cars);

        // then
        assertThat(winners.size()).isEqualTo(1);
        assertThat(winners.get(0).name()).isEqualTo(winner.name());
    }

    @Test
    @DisplayName("자동차 경주 결과의 우승자가 여러명인 경우 모두 반환할 수 있어야 한다.")
    void findRaceWinnersTest() {

        // given
        Car winner1 = new Car("우승자1");
        Car winner2 = new Car("우승자2");
        winner1.forward();
        winner2.forward();
        List<Car> cars = Arrays.asList(
            new Car("자동차1"),
            new Car("자동차2"),
            new Car("자동차3"),
            winner1,
            winner2
        );
        CarRacing carRacing = new CarRacing();

        // when
        List<Car> winners = carRacing.findWinners(cars);

        // then
        assertThat(winners.size()).isEqualTo(2);
        assertThat(winners).contains(winner1);
        assertThat(winners).contains(winner2);
    }

}