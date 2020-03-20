package step3;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingGameTest {

    private InputView inputView;

    @BeforeEach
    void newObject() {
        inputView = new InputView();
    }

    @DisplayName("사용자에게 경주 할 자동차 개수를 입력받는다.")
    @Test
    void inputCarCount() {
        int carCount = 3;
        inputView.inputCarCount(carCount);
        assertThat(inputView.getCarCount()).isEqualTo(carCount);

    }

    @DisplayName("사용자에게 몇번 이동 할건지 입력 받는다.")
    @Test
    void inputMoveCount() {
        int moveCount = 5;
        inputView.inputMoveCount(moveCount);
        assertThat(inputView.getMoveCount()).isEqualTo(moveCount);
    }

}