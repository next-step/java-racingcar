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
        ManualMovement manualMovement = new ManualMovement(input);

        int result = manualMovement.movement();

        assertThat(result).isEqualTo(input);
    }

}