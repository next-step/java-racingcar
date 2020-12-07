package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest {

    private final InputView inputView = new InputView();

    @Test
    @DisplayName("자동차 대수 입력 테스트")
    void inputCarCount() {
        inputView.printQuestions("자동차 대수는 몇 대 인가요?");
        Scanner scanner = new Scanner("3");
        inputView.inputCarCount(scanner);
        assertThat(inputView.getCarCount()).isEqualTo(3);
    }

    @Test
    @DisplayName("이동횟수 입력 테스트")
    void inputMoveCount() {
        inputView.printQuestions("시도할 회수는 몇 회 인가요?");
        Scanner scanner = new Scanner("5");
        inputView.inputMoveCount(scanner);
        assertThat(inputView.getMoveCount()).isEqualTo(5);
    }

}