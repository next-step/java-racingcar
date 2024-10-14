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

    @Test
    @DisplayName("모든 이름이 유효하지 않을 때 빈 리스트 반환")
    public void splitAndValidateCarNames_ShouldReturnEmptyList_WhenAllNamesAreInvalid() {
        assertThat(CarHelper.splitCarName("   ,toolongname,anotherlong")).isEmpty();
    }

    @Test
    @DisplayName("이름 앞뒤의 공백을 제거하고 유효한 이름만 반환")
    public void splitAndValidateCarNames_ShouldTrimAndReturnValidNames() {
        List<String> expectedValue = Arrays.asList("pobi", "crong");

        assertThat(CarHelper.splitCarName(" pobi , crong ,  toolongname "))
                .isEqualTo(expectedValue);
    }
}
