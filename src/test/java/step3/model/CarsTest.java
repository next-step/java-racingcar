package step3.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class CarsTest {

    @DisplayName("0이하의 자동차 대수를 입력할 경우 IllegalArgumentException 을 호출")
    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void invalidInput(int invalidNumberOfCars) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Cars(invalidNumberOfCars));
    }
}