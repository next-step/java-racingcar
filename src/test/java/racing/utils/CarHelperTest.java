package racing.utils;

import com.racing.utils.CarHelper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class CarHelperTest {

    @Test
    @DisplayName("구분자(,)를 기준으로 String으로 분리")
    public void isEquals_SplitStringFromDelegate() {
        List<String> expectedValue = Arrays.asList("pobi", "crong", "honux");

        assertThat(CarHelper.splitCarName("pobi,crong,honux")).isEqualTo(expectedValue);
    }

    @ParameterizedTest
    @DisplayName("5글자 이하일 경우 true, 6글자 이상일 경우 false반환")
    @CsvSource(value = {"poby:true", "crong:true", "honux:true", "testtttt:false", "qweqweqwe:false"}, delimiter = ':')
    void isEquals_ShouldEqualsExpectedValueSet(String carName, boolean expected) {
        assertThat(CarHelper.isValidCarName(carName)).isEqualTo(expected);
    }
}
