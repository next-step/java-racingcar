package carracing.view;

import carracing.domain.CarName;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class InputViewTest {

    @ParameterizedTest(name = "유효하지 않은 입력값이 들어오면 예외가 발생한다.")
    @ValueSource(strings = {"-1", "a"})
    public void validateMoveCountTest(String invalidInput) {
        InputView inputView = InputView.of(new ByteArrayInputStream(invalidInput.getBytes()));
        assertThatIllegalArgumentException()
                .isThrownBy(() -> inputView.getMoveCount())
                .withMessageContaining(invalidInput);
    }

    @DisplayName("자동차 이름은 ,를 기준으로 구분한다.")
    @Test
    public void carNamesParsingTest() {
        List<String> carNames = IntStream.rangeClosed(1, 3).mapToObj(i -> "car"+i).collect(Collectors.toList());
        InputView inputView = InputView.of(new ByteArrayInputStream(String.join(",", carNames).getBytes()));
        List<CarName> expected = carNames.stream()
                                    .map(name -> CarName.of(name))
                                    .collect(Collectors.toList());
        assertThat(inputView.getCarNames()).isEqualTo(expected);
    }

}