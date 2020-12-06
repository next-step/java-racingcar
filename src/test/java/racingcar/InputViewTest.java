package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

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

    @Test
    @DisplayName("자동차 이름 입력 테스트")
    void inputCarNames() {
        inputView.printQuestions("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        Scanner scanner = new Scanner("pobi,crong,honux");
        inputView.inputCarNames(scanner);
        assertThat(inputView.getCarCount()).isEqualTo(3);
    }

    @Test
    @DisplayName("자동차 이름이 5글자가 넘을 경우 테스트")
    void inputCarNamesException() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            inputView.printQuestions("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
            Scanner scanner = new Scanner("pobi,crong,honuxe");
            inputView.inputCarNames(scanner);
            assertThat(inputView.getCarCount()).isEqualTo(3);
        });
    }

}