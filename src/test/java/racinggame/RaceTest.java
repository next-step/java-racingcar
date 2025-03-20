package racinggame;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class RaceTest {

    private static final int INITIAL_CAR_POSITION = 1;

    @Nested
    @DisplayName("주어진 횟수만큼 자동차의 위치를 전진시키거나 멈춘다.")
    class Racing {

        @DisplayName("전진 조건을 만족하지 않으면 자동차는 움직이지 않는다.")
        @Test
        void notMove() {
            List<Car> cars = List.of(
                new Car("test1", new FakeMoveStrategy(false)),
                new Car("test2", new FakeMoveStrategy(false)),
                new Car("test3", new FakeMoveStrategy(false))
            );
            Cars race = new Cars(cars);
            race.run(3);
            for (Car car : race.getCars()) {
                assertThat(car.getPosition()).isEqualTo(INITIAL_CAR_POSITION);
            }
        }

        @DisplayName("전진 조건을 만족하면 자동차는 경주 횟수만큼 움직인다.")
        @Test
        void move() {
            int rounds = 3;
            List<Car> cars = List.of(
                new Car("test1", new FakeMoveStrategy(true)),
                new Car("test2", new FakeMoveStrategy(true)),
                new Car("test3", new FakeMoveStrategy(true))
            );
            Cars race = new Cars(cars);
            race.run(rounds);
            for (Car car : race.getCars()) {
                assertThat(car.getPosition()).isEqualTo(INITIAL_CAR_POSITION + rounds);
            }
        }
    }

    @Nested
    @DisplayName("우승자를 결정한다.")
    class winners {

        @DisplayName("자동차가 한 대일 때, 해당 자동차가 우승자가 된다.")
        @Test
        void oneCar() {
            List<Car> cars = List.of(
                new Car("test1", new FakeMoveStrategy(true))
            );
            Cars race = new Cars(cars);
            race.run(3);
            List<Car> winners = race.getWinners();

            assertThat(winners).hasSize(1);
            assertThat(winners.get(0).getName()).isEqualTo("test1");
        }

        @DisplayName("자동차 여러 대 중 하나가 우승했을 때, 우승자는 한 명이다.")
        @Test
        void oneWinner() {
            List<Car> cars = List.of(
                new Car("test1", new FakeMoveStrategy(false)),
                new Car("test2", new FakeMoveStrategy(true)),
                new Car("test3", new FakeMoveStrategy(false))
            );
            Cars race = new Cars(cars);
            race.run(3);

            List<Car> winners = race.getWinners();

            assertThat(winners).hasSize(1);
            assertThat(winners.get(0).getName()).isEqualTo("test2");
        }

        @DisplayName("자동차 여러 대 중 공동 우승자가 있을 때, 우승자는 여러 명이다.")
        @Test
        void multipleWinners() {
            List<Car> cars = List.of(
                new Car("test1", new FakeMoveStrategy(true)),
                new Car("test2", new FakeMoveStrategy(true)),
                new Car("test3", new FakeMoveStrategy(false))
            );
            Cars race = new Cars(cars);
            race.run(3);

            List<Car> winners = race.getWinners();

            assertThat(winners).hasSize(2)
                .extracting(Car::getName)
                .containsExactlyInAnyOrder("test1", "test2");
        }
    }
}
