package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;

class RacingCarsTest {

    private static String inputName = "A,B,C,D";


    @Test
    @DisplayName("참가 자동차 수는 inputName의 이름의 개수와 같다")
    void createRacingCarsTest() {

        RacingCars sut = new RacingCars(inputName);

        assertThat(sut.numberOfParticipants()).isEqualTo(4);
    }

    @Test
    @DisplayName("moveCar 매개변수가 4이상이면 자동차가 전진한다")
    void moveCarTest() {
        RacingCars sut = new RacingCars(inputName);
        sut.moveCar(car -> car.moveForward(4));

        for (Car racingCar : sut.getRacingCars()) {
            assertThat(racingCar.getPosition()).isEqualTo(1);
        }
    }


    @DisplayName("우승자는 한명 이상일 수 있다")
    @Test
    void winnersTest() {

        // given
        RacingCars sut = new RacingCars(inputName);
        sut.moveCar(car -> car.moveForward(5));

        // when
        List<Car> winners = sut.getWinners();

        // then
        assertThat(winners).containsAnyElementsOf(sut.getRacingCars());
    }

}