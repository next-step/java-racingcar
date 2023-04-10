package racing.carRacing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class ManualMovementTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5})
    @DisplayName("메뉴얼 값 지정 테스트")
    void manualTest(int input) {
        int condition = 4;
        ManualMovement manualMovement = new ManualMovement(input, condition);

        assertThat(manualMovement.getManualNumber()).isEqualTo(input);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5})
    @DisplayName("조건 숫자에 미달할 경우 true")
    void conditionTrue(int input) {
        int condition = 4;
        ManualMovement manualMovement = new ManualMovement(input, condition);

        assertThat(manualMovement.movement()).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 3})
    @DisplayName("조건 숫자에 미달할 경우 false")
    void conditionFalse(int input) {
        int condition = 4;
        ManualMovement manualMovement = new ManualMovement(input, condition);

        assertThat(manualMovement.movement()).isFalse();
    }

}
