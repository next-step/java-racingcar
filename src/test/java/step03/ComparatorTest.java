package step03;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class ComparatorTest {

    @DisplayName("number 가 standard 이상인지 테스트")
    @ParameterizedTest
    @CsvSource(value = {"4:5:false", "5:4:true"}, delimiter = ':')
    public void Test(int number, int standard, boolean expected) {
        final boolean result = Comparator.isNumberMoreThanStandard(number, standard);
        assertThat(result).isEqualTo(expected);
    }
}
