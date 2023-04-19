package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RacingCarTest {

    @Test
    @DisplayName("자동차 경주 3대 1회")
    void racing() {
        String cars = "pobi,crong,honux";
        Move move = new MoveRandom();
        List<Integer> randomList = Arrays.asList(1, 5, 7);
        RacingCar racingCar = new RacingCar(cars, move);

        racingCar.start(randomList);

        List<Car> carStatus = racingCar.getCars();
        assertThat(carStatus.stream().filter(car -> car.getName().equals("pobi")).findFirst().get().getDistance()).isEqualTo(0);
        assertThat(carStatus.stream().filter(car -> car.getName().equals("crong")).findFirst().get().getDistance()).isEqualTo(1);
        assertThat(carStatus.stream().filter(car -> car.getName().equals("honux")).findFirst().get().getDistance()).isEqualTo(1);

    }

    @Test
    @DisplayName("자동차 경주 우승자")
    void winner() {
        String cars = "pobi,crong,honux";
        List<Integer> randomList1 = Arrays.asList(1, 5, 7);
        List<Integer> randomList2 = Arrays.asList(2, 6, 3);

        Move move = new MoveRandom();
        RacingCar racingCar = new RacingCar(cars, move);

        racingCar.start(randomList1);
        racingCar.start(randomList2);

        List<String> winners = racingCar.getWinner();

        assertThat(winners).containsExactly("crong");
    }

    @Nested
    @DisplayName("이름 분리 관련 테스트")
    class split{
        @Test
        @DisplayName("이름 분리 통과")
        void split () {
            RacingCar racingCar = new RacingCar("pobi,crong,honux", new MoveRandom());

            assertThat(racingCar.getCars()).map(Car::getName).containsExactly("pobi", "crong", "honux");
        }

        @Test
        @DisplayName("참가한 자동차가 없을 경우")
        void splitExceptionNoPlayer() {
            assertThatThrownBy(()-> { RacingCar racingCar = new RacingCar("", new MoveRandom()); })
                    .isInstanceOf(RuntimeException.class).hasMessageContaining("player zero");
        }

    }

}
