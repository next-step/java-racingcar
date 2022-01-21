package racinggame.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.Test;

class ViewTest {

    @Test
    void 상태를_출력할_자동차_리스트를_받아_생성한다() {

        // given
        String[] cars = {"car1", "car2"};
        List<RacingCar> racingCars = RacingCar.createRacingCarFromCarNames(cars);

        // when
        View view = new View(racingCars);

        // then
        assertThat(view.getRacingCars()).isEqualTo(racingCars);
    }

    @Test
    void 현재_자동차들의_상태를_출력한다() {

        // given
        String[] cars = {"car1", "car2"};
        List<RacingCar> racingCars = RacingCar.createRacingCarFromCarNames(cars);
        View view = new View(racingCars);

        // when
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        view.printProgress();

        // then
        assertTrue(out.toString().contains("car1"));
        assertTrue(out.toString().contains("car2"));
    }

    @Test
    void 우승자를_출력() {

        // given
        String[] cars = {"car1", "car2"};
        List<RacingCar> racingCars = RacingCar.createRacingCarFromCarNames(cars);
        View view = new View(racingCars);

        // when
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        view.printWinners();

        // then
        assertTrue(out.toString().contains("car1, car2"));
    }
}