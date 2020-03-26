package step5.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;


import step5.domain.Car;
import step5.domain.Cars;

class InputViewTest {
    private InputView inputView;

    @DisplayName("입력받은 값을 유효성 검사한다")
    @ParameterizedTest
    @NullAndEmptySource
    void validateInput(String carNames) {
        inputView = new InputView();
        assertThatIllegalArgumentException().isThrownBy(() -> {
            inputView.validateInput(carNames);
        });
    }

    @DisplayName("입력 받은 자동차 이름을 ,로 자른다")
    @Test
    void splitUserCarName() {
        String carNames = "soojung,crystal,han";
        int moveCount = 7;
        inputView = new InputView(carNames, moveCount);
        assertThat(inputView.splitCarName(carNames)).containsExactly("soojung", "crystal", "han");
    }


}
