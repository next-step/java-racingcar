package ThirdStep;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

class CarRacingGameTest {

    private final static int CARS = 3;
    private final static int ATTEMPTS = 5;

    @BeforeEach
    void initInput() {
        InputStream settings = new ByteArrayInputStream(String.format("%d %d", CARS, ATTEMPTS).getBytes());
        System.setIn(settings);
    }

    @Test
    @DisplayName("게임에 참여할 자동차 수와 시도 회수를 입력받고 저장할 수 있다.")
    void 경기_셋팅_테스트() {
        CarRacingGame.racing();

        assertThat(CarRacingGame.cars).isEqualTo(3);
        assertThat(CarRacingGame.attempts).isEqualTo(5);
    }
}
