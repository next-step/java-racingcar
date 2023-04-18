package step4;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest {
    @Test
    public void 차이름_길이_제한_테스트() {
        InputView inputView = new InputView();
        String overLengthName = "12345";
        assertThat(inputView.isOverLimit(overLengthName)).isTrue();
    }
}
