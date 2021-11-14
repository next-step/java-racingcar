package racing.basic.domain;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayName("자동차 게임 도메인 테스트(라인 갯수 3)")
class CarRacingGameTest {

    private CarRacingGame carRacingGame;

    @Mock
    private Random random;

    @BeforeEach
    void setUp() {
        carRacingGame = new CarRacingGame(random, 3);
    }

    @Test
    @DisplayName("전진 판단 랜덤 값이 모두 4 일 경우, 모든 자동차 전진")
    public void workCar() {
        int[] desiredResult = {1, 1, 1};

        when(random.nextInt())
            .thenReturn(4);

        int[] resultTrack = carRacingGame.nextRound();
        assertArrayEquals(desiredResult, resultTrack);
    }

    @Test
    @DisplayName("전진 판단 랜덤 값이 모두 3 일 경우, 모든 자동차 정지")
    public void stopCar() {
        int[] desiredResult = {0, 0, 0};

        when(random.nextInt())
            .thenReturn(3);

        int[] resultTrack = carRacingGame.nextRound();
        assertArrayEquals(desiredResult, resultTrack);
    }
}