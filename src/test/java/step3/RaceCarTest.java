package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step3.operation.Operation;
import step3.operation.ValidationUtils;
import step3.view.InputView;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceCarTest {

    @DisplayName("4이상일 경우 전진")
    @ParameterizedTest
    @CsvSource(value = {"4:1","3:0","5:0"}, delimiter = ':')
    public void 전진_OR_정지(int random, int result) {
        Operation operation = new Operation();
        assertThat(operation.decideToMove(random, 0)).isEqualTo(result);
    }

    @DisplayName("10보다 작은 random 수 생성 테스트")
    @Test
    public void random_수_생성() {
        Operation operation = new Operation();
        operation.makeRandomValue(10);
    }

    @DisplayName("최종 테스트")
    @Test
    public void 경주() {
        InputView inputView = new InputView();
        Operation operation = new Operation();
        int numOfCars = inputView.numOfCars();
        int numOfAtp = inputView.numberOfAttempts();

        operation.gameStart(numOfAtp, numOfCars);

    }

    @DisplayName("자동차 이름 유효성 테스트")
    @Test
    public void valid_name() {
        assertThat(ValidationUtils.validationName("pobi")).isTrue();
    }

    @DisplayName("자동차 이름 유효성 테스트2")
    @Test
    public void invalid_name() {
        assertThat(ValidationUtils.validationName("kkkkkk")).isFalse();
        assertThat(ValidationUtils.validationName(" ")).isFalse();
        assertThat(ValidationUtils.validationName("")).isFalse();
        assertThat(ValidationUtils.validationName(null)).isFalse();
    }

}
