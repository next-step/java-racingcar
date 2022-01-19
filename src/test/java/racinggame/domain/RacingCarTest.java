package racinggame.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
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

        car.forward();

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 자동차_이름과_위치출력() {
        RacingCar car = new RacingCar("car");

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        car.printCurrPosition();

        assertEquals("car  : ", out.toString());
    }

    @Test
    void 자동차_이름과_위치출력_한칸_전진() {
        RacingCar car = new RacingCar("car");

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        car.forward();
        car.printCurrPosition();
        assertEquals("car  : -", out.toString());
    }
}