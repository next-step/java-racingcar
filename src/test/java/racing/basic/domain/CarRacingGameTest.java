package racing.basic.domain;

import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("자동차 게임 도메인 테스트(라인 갯수 3)")
class CarRacingGameTest {

    private CarRacingGame carRacingGame;

    @BeforeEach
    void setUp() {
        carRacingGame = new CarRacingGame(3);
    }

    @Test
    @DisplayName("전진 판단 랜덤 값이 모두 4 일 경우, 모든 자동차 전진")
    public void workCar() {
        List<Integer> desiredResult = Arrays.asList(1, 1, 1);
        List<Integer> diceNumbers = Arrays.asList(4, 4, 4);

        List<Integer> resultTrack = carRacingGame.nextRound(diceNumbers);

        assertEquals(desiredResult, resultTrack);
    }

    @Test
    @DisplayName("전진 판단 랜덤 값이 모두 3 일 경우, 모든 자동차 정지")
    public void stopCar() {
        List<Integer> desiredResult = Arrays.asList(0, 0, 0);
        List<Integer> diceNumbers = Arrays.asList(3, 3, 3);

        List<Integer> resultTrack = carRacingGame.nextRound(diceNumbers);

        assertEquals(desiredResult, resultTrack);
    }

    @Test
    @DisplayName("{4, 3, 9} 값 입력 시, 결과값 {1, 0, 1} 리턴")
    public void workAndStopCar() {
        List<Integer> desiredResult = Arrays.asList(1, 0, 1);
        List<Integer> diceNumbers = Arrays.asList(4, 3, 9);

        List<Integer> resultTrack = carRacingGame.nextRound(diceNumbers);

        assertEquals(desiredResult, resultTrack);
    }
}