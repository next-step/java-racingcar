package racing;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class StringValidatorTest {

    @ParameterizedTest
    @CsvSource(value = {"pobi:true", "invalidName:false"}, delimiter = ':')
    void 이름_validation_check_test(String carName, boolean expected) {
        boolean isValid = StringValidator.isLessThanEqualLen(carName, 5);

        assertThat(isValid).isEqualTo(expected);
    }
}