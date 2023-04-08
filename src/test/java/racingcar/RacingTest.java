package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


@DisplayName("레이스 테스트")
public class RacingTest {

    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void 시스템_아웃_세팅() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        Racing.setRace(3, 2);
    }

    @Test
    void 레이스_시작() {
        Racing.startRace();
        List<Car> cars = Racing.getCars();
        for (int i = 0; i < cars.size(); i++) {
            assertThat(cars.get(i).getPosition()).isBetween(0, 9);
        }
    }

    @Test
    void 레이스_세팅() {
        Racing.setRace(3, 10);
        assertThat(Racing.getCars()).hasSize(3);
        assertThat(Racing.getRaceCount()).isEqualTo(10);
        assertThat(Racing.getRaceResults()).isNotNull();
    }

}
