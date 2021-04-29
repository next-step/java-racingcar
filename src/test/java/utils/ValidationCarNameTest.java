package utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidationCarNameTest {

    @Test
    @DisplayName("차 이름이 5자리 이하일 때")
    void is_the_car_name_less_than_5_digits() {
        boolean result = ValidationCarName.isCarNameLessThanFiveDigits("asdf");
        assertTrue(result);
    }

    @Test
    @DisplayName("차 이름이 5자리 이상일 때")
    void is_the_car_name_longer_than_5_digits() {
        boolean result = ValidationCarName.isCarNameLessThanFiveDigits("asdfㄹㄹ");
        assertFalse(result);
    }

    @Test
    @DisplayName("쉼표(,)를 기준으로 차 이름이 나오나?")
    void split_car_name_based_on_commas() {
        String[] result = ValidationCarName.splitBasedOnCommas("santa,sona,corna");
        Assertions.assertThat(result)
                .containsExactly("santa", "sona", "corna");
    }
}
