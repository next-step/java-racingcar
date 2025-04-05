package carrace.rules;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static carrace.rules.CarRaceRules.checkLargerThanMaxCarNameLength;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarRaceRulesTest {

    @DisplayName("0 이상 10 미만의 랜덤값이 나와야합니다.")
    @Test
    public void generateRandomValueTest_ValidRandomValue() {
        int randomValue = CarRaceRules.generateRandomValue();
        assertThat(randomValue).isBetween(0, 10);
    }

    @DisplayName("다섯글자 이하의 자동차 이름이면 true가 반환됩니다.")
    @Test
    public void checkLargerThanMaxCarNameLengtht_ValidCarName() {
        String input = "valid";
        assertThat(checkLargerThanMaxCarNameLength(input)).isFalse();
    }

    @DisplayName("다섯글자 초과의 자동차 이름이면 false가 반환됩니다.")
    @Test
    public void checkLargerThanMaxCarNameLengtht_InvalidCarName() {
        String input = "invalidCarNameLength";
        assertThat(checkLargerThanMaxCarNameLength(input)).isTrue();
    }
}
