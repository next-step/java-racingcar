package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.RacingCar;
import racingcar.domain.Round;
import racingcar.pattern.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingCarTest {
    @Test
    @DisplayName("round가 음수일땐 에러를 뱉는다.")
    void argumentExceptionErrorTest() {
        int round = -1;

        Cars cars = Cars.createCars("green,so");
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        assertThatThrownBy(() -> new RacingCar(cars, new Round(round), randomNumberGenerator))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("라운드는 음수가 될 수 없습니다");
    }

    @Test
    @DisplayName("입력받은 라운드 보다 더 많은 라운드를 진행할때 에러를 뱉는다.")
    void roundErrorTest() {
        int round = 4;

        Cars cars = Cars.createCars("green,so");
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        RacingCar racingCar = new RacingCar(cars, new Round(round), randomNumberGenerator);

        for (int currentRound = 0; currentRound < round; currentRound++) {
            racingCar.playRound();
        }

        assertThatThrownBy(racingCar::playRound)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("우승자를 찾는 테스트")
    void findWinner() {
        List<Car> carList = new ArrayList<>();
        Car winner = new Car("win",4);
        carList.add(winner);
        carList.add(new Car("lose",2));
        RacingCar racingCar = new RacingCar(new Cars(carList), new Round(3), new RandomNumberGenerator());

        assertThat(racingCar.findWinners().getWinners().get(0)).isEqualTo(winner);
    }
}
