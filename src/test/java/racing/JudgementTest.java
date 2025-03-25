package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.Car;
import racing.domain.Cars;
import racing.domain.Judgement;
import racing.domain.RacingGame;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JudgementTest {

    @Test
    @DisplayName(value = "승자 테스트")
    void 승자_출력_테스트() {

        Cars cars = new Cars()
                .addCar(new Car("A",4))
                .addCar(new Car("B",4))
                .addCar(new Car("C",2));

        RacingGame racingGame = new RacingGame(cars);

        assertThat(racingGame.getWinnerCars()).isEqualTo(List.of(cars.getCar(0), cars.getCar(1)));
    }
}
