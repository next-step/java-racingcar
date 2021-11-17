package racing.basic.domain;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

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
        int[] desiredResult = {1, 1, 1};
        int[] resultTrack = carRacingGame.nextRound(new int[]{4, 4, 4});
        assertArrayEquals(desiredResult, resultTrack);
    }

    @Test
    @DisplayName("전진 판단 랜덤 값이 모두 3 일 경우, 모든 자동차 정지")
    public void stopCar() {
        int[] desiredResult = {0, 0, 0};
        int[] resultTrack = carRacingGame.nextRound(new int[]{3, 3, 3});
        assertArrayEquals(desiredResult, resultTrack);
    }

    @Test
    @DisplayName("{4, 3, 9} 값 입력 시, 결과값 {1, 0, 1} 리턴")
    public void workAndStopCar() {
        int[] desiredResult = {1, 0, 1};
        int[] resultTrack = carRacingGame.nextRound(new int[]{4, 3, 9});
        assertArrayEquals(desiredResult, resultTrack);
    }
}