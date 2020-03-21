package step3;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {

    private InputView inputView;

    @DisplayName("사용자에게 경주 할 자동차 개수를 입력받는다.")
    @Test
    void inputCarCount() {
        int carCount = 5;
        int moveCount = 8;
        inputView = new InputView(carCount, moveCount);
        assertThat(inputView.getCarCount()).isEqualTo(carCount);

    }

    @DisplayName("사용자에게 몇번 이동 할건지 입력 받는다.")
    @Test
    void inputMoveCount() {
        int carCount = 3;
        int moveCount = 5;
        inputView = new InputView(carCount, moveCount);
        assertThat(inputView.getMoveCount()).isEqualTo(moveCount);
    }

}
