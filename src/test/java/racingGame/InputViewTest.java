package racingGame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest {

    @ParameterizedTest
    @ValueSource(strings = "pobi,crong,honux")
    @DisplayName("입력받은 String을 , 단위로 분리하여 리스트로 만든다.")
    void splitStringWithCommaToList(String input) {
        List<Car> result = InputView.splitStringWithCommaToList(input);
        assertThat(result).containsExactly(
                new Car("pobi"),
                new Car("crong"),
                new Car("honux"));
    }
}
