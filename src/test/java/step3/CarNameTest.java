package step3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarNameTest {
    @ParameterizedTest
    @CsvSource(value = {"abe,def,efg:true", "123,aaa,bbb:false", "abc;,dde,efe:false"}, delimiter = ':')
    void verifyCarNames(String input, boolean result) {
        assertThat(CarName.verifyCarNames(input)).isEqualTo(result);
    }
}