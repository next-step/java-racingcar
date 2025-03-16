package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RacingCarTest {

    public static final int CAR = 5;
    public static final int NUM = 3;

    @Test
    public void racingCar_배열의크기() {
        int[][] result = RacingCar.racing(CAR, NUM);

        // 반환된 배열의 크기를 확인
        assertEquals(NUM, result.length, "시도 횟수와 배열의 행 수가 일치해야 합니다.");
        assertEquals(CAR, result[0].length, "차량 수와 배열의 열 수가 일치해야 합니다.");
    }

    @Test
    public void racing_배열의크기() {
        int[][] result = RacingCar.racing(CAR, NUM);

        // 반환된 배열의 크기를 확인
        assertEquals(NUM, result.length, "게임 횟수와 배열의 행 수가 일치해야 합니다.");
        assertEquals(CAR, result[0].length, "차량 수와 배열의 열 수가 일치해야 합니다.");
    }

    @Test
    public void racing_이동횟수() {
        int car = 5; // 차량 수
        int num = 3; // 게임 횟수
        int[][] result = RacingCar.racing(car, num);

        // 각 차량의 이동 횟수가 0 이상인지 확인
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < car; j++) {
                assertTrue(result[i][j] >= 0, "모든 이동 횟수는 0 이상이어야 합니다.");
            }
        }
    }

    @Test
    public void racing_이전게임횟수비교() {
        int[][] result = RacingCar.racing(CAR, NUM);

        // 각 게임 결과가 이전 게임의 결과를 기반으로 하는지 확인
        for (int i = 1; i < NUM; i++) {
            for (int j = 0; j < CAR; j++) {
                assertTrue(result[i][j] >= result[i - 1][j], "이동 횟수는 이전 게임의 이동 횟수보다 크거나 같아야 합니다.");
            }
        }
    }

    @Test
    public void moveCar_이전게임횟수비교() {
        int car = 5;
        int[] moves = {1, 2, 3, 4, 5};
        int[] originalMoves = moves.clone(); // 원본 배열 복사

        int[] result = RacingCar.moveCar(car, moves);

        // 각 요소가 이전 상태보다 크거나 같은지 확인
        for (int i = 0; i < car; i++) {
            assertTrue(result[i] >= originalMoves[i], "각 요소는 원본보다 크거나 같아야 합니다.");
        }

    }

    @Test
    @DisplayName("랜덤 숫자 테스트")
    public void getRandom() {
        int result = RacingCar.getRandomNumber();
        assertTrue(result >= 0 && result <= 9, "값은 0과 9 사이여야 합니다.");
    }
}
