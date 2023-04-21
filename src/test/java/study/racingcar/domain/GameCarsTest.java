package study.racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameCarsTest {
    @Nested
    class WinnerTest {
        private GameCars cars;
        @BeforeEach
        void setUp() {
            List<String> carNames = List.of("pobi", "crong", "honux", "junho");
            cars = new GameCars(carNames);
            for (Car car : cars) {
                if (car.getCarName().equals("pobi")) {
                    car.move();
                }
                if (car.getCarName().equals("crong")) {
                    car.move();
                    car.move();
                }
                if (car.getCarName().equals("honux")) {
                    car.move();
                    car.move();
                    car.move();
                }
                if (car.getCarName().equals("junho")) {
                    car.move();
                    car.move();
                    car.move();
                }
            }
        }

        @DisplayName("winner가 두명일 경우 공동 우승 테스트")
        @Test
        void when_ThereAreTwoWinners_Expects_TwoWinners() {
            // when
            Winners winners = cars.calculateWinner();

            //then
            assertThat(winners.getWinners())
                    .extracting(Car::getCarName)
                    .hasSize(2)
                    .containsExactly("honux", "junho");
        }

        @DisplayName("winner가 한명일 경우 테스트")
        @Test
        void when_ThereIsOnlyOneWinners_Expects_OneWinner() {
            //given
            for (Car car : cars) {
                if (car.getCarName().equals("junho")) {
                    car.move();
                }
            }

            // when
            Winners winners = cars.calculateWinner();

            //then
            assertThat(winners.getWinners())
                    .extracting(Car::getCarName)
                    .hasSize(1)
                    .containsExactly("junho");
        }
    }

    @DisplayName("리스트의 크기 만큼 Car 객체를 생성하는지 테스트")
    @Test
    void when_InputListsAreGiven_Expects_GenerateCarObjects() {
        // given
        List<String> carNames = List.of("pobi", "junho", "crong", "honux");

        // when
        GameCars cars = new GameCars(carNames);

        // then
        assertThat(cars).hasSize(carNames.size());
    }

    @DisplayName("리스트 크기가 1일 경우 컬렉션 크기 1 검증")
    @Test
    void when_InputSizeIsOne_Expects_SizeOne() {
        // given
        List<String> carNames = List.of("pobi");

        // when
        GameCars cars = new GameCars(carNames);

        // then
        assertThat(cars).hasSize(1);
    }

    @DisplayName("empty list일 경우 컬렉션 크기 0인지 검증")
    @Test
    void when_InputIsEmptyList_Expects_SizeZero() {
        // given
        List<String> carNames = List.of();

        // when
        GameCars cars = new GameCars(carNames);

        // then
        assertThat(cars).hasSize(0);
    }
}