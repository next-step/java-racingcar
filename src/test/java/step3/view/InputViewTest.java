package step3.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static step3.Fixture.inputView;

class InputViewTest {
    @ParameterizedTest
    @DisplayName("자동차 대수 및 시도 회수에 0또는 음수를 넣으면 오류를 발생시킨다.")
    @ValueSource(ints = {0, -1})
    void validateNumCar(int input) {
        assertThatThrownBy(() -> inputView.isPositiveNum(input)).isInstanceOf(IllegalArgumentException.class);
    }
}