package racingcar.domain.race;

import org.junit.Before;
import org.junit.Test;
import racingcar.domain.car.Car;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class RankingTest {

    private List<Car> cars;
    //TODO : 좋은 TC 유형아님 , 개선필요


    @Before
    public void setUp() throws Exception {
        cars = Arrays.asList(
                new Car("po", 2)
                , new Car("jo", 6)
                , new Car("go", 3)
                , new Car("yo", 6)
        );
    }

    @Test
    public void sortRanking() {

        Ranking.sort(cars);

        for (Car car : cars) {
            System.out.println(car.getName() + " : " + car.getPosition());
        }

        assertThat(cars.get(0).getPosition()).isEqualTo(6);
        assertThat(cars.get(1).getPosition()).isEqualTo(6);
        assertThat(cars.get(2).getPosition()).isEqualTo(3);
        assertThat(cars.get(3).getPosition()).isEqualTo(2);
    }

    @Test
    public void 우승자_찾기() {
        List<Car> cars = Arrays.asList(
                new Car("po", 2)
                , new Car("jo", 6)
                , new Car("go", 3)
                , new Car("yo", 6)
        );

        Ranking ranking = new Ranking();
        List<Car> winners = ranking.findWinner(cars);

        for (Car car : cars) {
            System.out.println(car.getName() + " : " + car.getPosition());
        }

        System.out.println("~wiiners~");

        for (Car car : winners) {
            System.out.println(car.getName() + " : " + car.getPosition());
        }


        assertThat(winners.size()).isGreaterThanOrEqualTo(1);
        //java7
        for (Car winner : winners) {
            assertThat(winner.getPosition()).isEqualTo(6);
        }

        //java8
        winners.forEach(winner -> assertThat(winner.getPosition()).isEqualTo(6));
    }
}