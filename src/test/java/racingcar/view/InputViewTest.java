package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

    @ParameterizedTest
    @ValueSource(strings = {"메르세데스벤츠,포르쉐", "현대, "})
    void test(String carNames) {
        String[] carNameArr = carNames.split(",");

        InputView input = new InputView();
        assertThatIllegalArgumentException().isThrownBy(() -> input.inputNameValid(carNameArr));
    }
}