package racingcar.view.input;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DefaultInputViewTest {

    @Test
    @DisplayName("입력한 자동차를 정상적으로 가져오는지 확인한다")
    void checkNumberOfCars() {
        // given
        InputView inputView = new DefaultInputView(new MockCommandLineReader(3, Arrays.asList("blue","red","yellow")));
        // when
        List<String> result = inputView.getCarNames();
        // then
        assertThat(result.size()).isEqualTo(3);
        assertThat(result.get(0)).isEqualTo("blue");
        assertThat(result.get(1)).isEqualTo("red");
        assertThat(result.get(2)).isEqualTo("yellow");
    }

    @Test
    @DisplayName("입력한 시도수를 정상적으로 가져오는지 확인한다")
    void checkNumberOfTimes() {
        // given
        InputView inputView = new DefaultInputView(new MockCommandLineReader(5, Arrays.asList("")));
        // when
        Integer result = inputView.getNumberOfTimes();
        // then
        assertThat(result).isEqualTo(5);
    }
}
