package step3;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingGameTest {

    private InputView inputView;
    private RacingGame racingGame;
    private ResultView resultView;

    @DisplayName("사용자에게 경주 할 자동차 개수를 입력받는다.")
    @Test
    void inputCarCount() {
        int carCount = 5;
        int moveCount = 8;
        inputView = new InputView(carCount, moveCount);
        inputView.inputCarCount(carCount);
        assertThat(inputView.getCarCount()).isEqualTo(carCount);

    }

    @DisplayName("사용자에게 몇번 이동 할건지 입력 받는다.")
    @Test
    void inputMoveCount() {
        int carCount = 3;
        int moveCount = 5;
        inputView = new InputView(carCount, moveCount);
        inputView.inputMoveCount(moveCount);
        assertThat(inputView.getMoveCount()).isEqualTo(moveCount);
    }

    @DisplayName("자동차 수 만큼 랜덤숫자를 뽑은 후 전진한다.")
    @Test
    void moveCarPositions() {
        racingGame = new RacingGame(5, 3);

        //전진하는 경우
        int forward = racingGame.forwardStatus(8);
        assertThat(forward).isEqualTo(1);

        //전진 못하는 경우
        int notForward = racingGame.forwardStatus(0);
        assertThat(notForward).isEqualTo(0);

        // 사용자에게 입력 받은 정보로 자동차를 움직인다.
        racingGame.moveByRepeatCount();
        int[] carPositions = racingGame.getCarPositions();
        assertThat(carPositions.length).isEqualTo(3);
        assertThat(carPositions).containsAnyOf(0, 1, 2, 3, 4, 5);
        System.out.println(Arrays.toString(carPositions));
    }

    @DisplayName("자동차 레이싱 결과를 출력한다.")
    @Test
    void name() {
        int[] result = { 3, 2, 1 };
        resultView = new ResultView(result);
        resultView.settingresultCarPositions();
        String[] resultCarPositions = resultView.getResultCarPositions();
        assertThat(resultCarPositions).hasSize(result.length);
        assertThat(resultCarPositions).containsExactly("---", "--", "-");
    }
}