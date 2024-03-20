package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.MoveStrategy;
import racingcar.domain.RacingCars;


import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RacingCarsTest {

    private static String inputName = "A,B,C,D";


    @Test
    @DisplayName("참가 자동차 수는 inputName의 이름의 개수와 같다")
    void createRacingCarsTest() {

        RacingCars sut = new RacingCars(inputName);

        assertThat(sut.numberOfParticipants()).isEqualTo(4);
    }


    @DisplayName("우승자는 한명 이상일 수 있다")
    @Test
    void winnersTest() {

        // given
        RacingCars sut = new RacingCars(inputName);
        sut.moveCar(() -> true);

        // when
        List<Car> winners = sut.getWinners();

        // then
        assertThat(winners).containsAnyElementsOf(sut.getRacingCars());
    }


    @Test
    @DisplayName("우승자는 position이 max인 자동차다")
    public void winnerTest() {
        RacingCars sut = new RacingCars(
                List.of(
                    new Car("A", 1),
                    new Car("B", 2),
                    new Car("C", 3)
                )
        );

        List<Car> winners = sut.getWinners();

        assertThat(winners).containsExactly(new Car("C", 3));
    }

}