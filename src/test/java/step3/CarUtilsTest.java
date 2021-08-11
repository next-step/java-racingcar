package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step3.domain.CarUtils;

import static org.assertj.core.api.Assertions.assertThat;

class CarUtilsTest {

    @ParameterizedTest
    @CsvSource(value = {"test:true", "abcde:true", "nextstep:false"}, delimiter = ':')
    @DisplayName("자동자 이름이 5글자를 초과하는지 확인한다.")
    void check_validate_carname_test(String carName, boolean expected) {

        boolean result = CarUtils.validateNameLength(carName);

        assertThat(result).isEqualTo(expected);
    }
}