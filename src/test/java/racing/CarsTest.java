package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class CarsTest {

    @ParameterizedTest
    @ValueSource(strings = {"javajigi, cwpark, ironman, cwpark"})
    @DisplayName("이름 중복 입력 시 테스트")
    void isDuplicationTest(String inputCarNames) {
        Cars cars = new Cars();
        assertThatIllegalArgumentException().isThrownBy(() -> cars.isDuplication(inputCarNames));
    }
}