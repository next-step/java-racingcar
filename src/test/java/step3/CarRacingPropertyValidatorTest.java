package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarRacingPropertyValidatorTest {

    CarRacingPropertyValidator validator;

    @BeforeEach
    void setUp() {
        validator = new CarRacingPropertyValidator();
    }

    @ParameterizedTest
    @DisplayName("1 이상의 정수만 Number 프로퍼티다")
    @ValueSource(ints = {10, 1000})
    void restriction1(int value) {
        assertThat(validator.validate(value)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("음수,0 은 Number 프로퍼티가 아니다")
    @ValueSource(ints = {0, -1, -100, -1000})
    void restriction2(int value) {
        assertThatThrownBy(() -> validator.validate(value))
                .isInstanceOf(InvalidPropertyValueException.class);
    }

}