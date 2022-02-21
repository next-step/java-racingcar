package racinggame.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.Test;

class RacingCarTest {

    @Test
    void 자동차_객체_생성() {
        RacingCar car = new RacingCar("car");

        assertThat(car.getCarName()).isEqualTo("car");
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 한_칸_전진() {
        RacingCar car = new RacingCar("car");

        car.moveForward(5);

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 자동차_이름과_위치출력() {
        RacingCar car = new RacingCar("car");

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        car.printCurrPosition();

        assertEquals("car  : \n", out.toString());
    }

    @Test
    void 자동차_이름과_위치출력_한칸_전진() {
        RacingCar car = new RacingCar("car");

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        car.moveForward(5);
        car.printCurrPosition();
        assertEquals("car  : -\n", out.toString());
    }

    @Test
    void 자동차이름_배열을_받아_자동차객체_리스트_생성() {
        String[] carNames = {"car1", "car2"};

        List<RacingCar> racingCars = RacingCar.createRacingCarFromCarNames(carNames);

        assertEquals(racingCars.get(0).getCarName(), carNames[0]);
        assertEquals(racingCars.get(1).getCarName(), carNames[1]);
    }
}