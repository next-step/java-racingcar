package domain.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarNameTest {

    @Test
    @DisplayName("자동차 이름은 5글자 이상일 때 에러")
    void validate_car_name_exceed_5_digits() {
        //given
        String name = "teslaa";

        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new CarName(name));

        //then
        assertEquals(exception.getMessage(), "자동차 이름은 5글자 이하여야만 합니다.");
    }

    @Test
    @DisplayName("자동차 이름은 5글자 이하 일 때")
    void validate_car_name_less_than_5_digits() {
        //given
        String name = "tesla";

        //when
        CarName carName = new CarName(name);

        //then
        assertEquals(name, carName.getName());
    }
}
