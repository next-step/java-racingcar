package carracing.step3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {

    private InputView inputView;

    private void setInputStream(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @BeforeEach
    void setUp() {
        inputView = new InputView();
    }

    @AfterEach
    void setDown() {

    }

    @ParameterizedTest(name = "자동차 대수 입력 테스트 : 입력 1 : 결과 1")
    @ValueSource(strings = {"1"})
    void enterCarCount(String input) {
        this.setInputStream(input);

        assertThat(this.inputView.enterCarCount()).isEqualTo(1);
    }

    @ParameterizedTest(name = "자동차 대수 입력 테스트 : 입력 d : 결과 NumberFormatException")
    @ValueSource(strings = {"d"})
    void enterCarCount2(String input) {
        this.setInputStream(input);

        assertThatThrownBy(() -> {
            this.inputView.enterCarCount();
        }).isInstanceOf(NumberFormatException.class).hasMessageContaining("잘못된 숫자를 입력하였습니다.");
    }

    @ParameterizedTest(name = "시도 횟수 입력 테스트 : 입력 2 : 결과 2")
    @ValueSource(strings = {"2"})
    void enterTryCount(String input) {
        this.setInputStream(input);

        assertThat(this.inputView.enterTryCount()).isEqualTo(2);
    }

    @ParameterizedTest(name = "시도 횟수 입력 테스트 : 입력 d : 결과 NumberFormatException")
    @ValueSource(strings = {"d"})
    void enterTryCount2(String input) {
        this.setInputStream(input);

        assertThatThrownBy(() -> {
            this.inputView.enterTryCount();
        }).isInstanceOf(NumberFormatException.class).hasMessageContaining("잘못된 숫자를 입력하였습니다.");
    }

}