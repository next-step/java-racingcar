package carracing;

import carracing.view.InputInfo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputInfoTest {

    @Test
    @DisplayName("숫자포멧에러")
    void valid() {
        assertThatThrownBy(() -> {
            new InputInfo("오", "육");
        }).isInstanceOf(NumberFormatException.class);
    }

    @Test
    @DisplayName("자동차 split 테스트")
    void split() {
        InputInfo inputInfo = new InputInfo("car1,car2", "1");
        Assertions.assertThat(inputInfo.getCarStringList().size()).isEqualTo(2);
    }
}
