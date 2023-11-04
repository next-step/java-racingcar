package racingcar;


import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest {

    private ByteArrayOutputStream outputStream;


    @Test
    void 상태출력() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        RacingCar racingCar = new RacingCar();
        racingCar.action(4); // 전진

        String result = outputStream.toString();

        assertThat(result).isEqualTo("-\n"); // 1칸 출력


    }

    @Test
    void 전진_조건_테스트_4이상() {
        RacingCar racingCar = new RacingCar(); // carPosition = 0

        racingCar.action(6);
        assertThat(racingCar.getCarPosition()).isEqualTo(1); // 전진
    }

    @Test
    void 전진_조건_테스트_4() {
        RacingCar racingCar = new RacingCar(); // carPosition = 0

        racingCar.action(4);
        assertThat(racingCar.getCarPosition()).isEqualTo(1); // 전진

    }

    @Test
    void 전진_조건_테스트_4미만() {
        RacingCar racingCar = new RacingCar(); // carPosition = 0

        racingCar.action(3);
        assertThat(racingCar.getCarPosition()).isEqualTo(0); // 정지

    }
}