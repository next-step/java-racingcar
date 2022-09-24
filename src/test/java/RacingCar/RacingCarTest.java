package RacingCar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingCarTest {

    @BeforeEach
    @DisplayName("시스템으로 입력한 스캐너 구현")
    void systemScan() {
        String input = "5";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @Test
    @DisplayName("스캐너 구현")
    void scanner() {
        int result = RacingCar.scan();

        assertThat(result).isInstanceOf(Integer.class);
    }

    @Test
    @DisplayName("랜덤 구현")
    void random() {
        int result = RacingCar.random();

        assertThat(result).isBetween(0, 9);
    }

    @Test
    @DisplayName("자동차 이동 구현")
    void move() {
        int result = RacingCar.move();

        assertThat(result).isBetween(0, 1);
    }


}
