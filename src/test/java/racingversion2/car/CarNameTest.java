package racingversion2.car;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarNameTest {

    @Test
    @DisplayName("5자를 초과하는 자동차 이름을 짓는 경우 예외처리")
    void invalidCarName(){
        assertThatThrownBy(()->CarName.of("5자가넘어가는이름"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "12", "123", "1234", "12345"})
    @DisplayName("5자 이하의 자동차 이름은 정상처리")
    void validCarName(String name){
        assertDoesNotThrow(()-> CarName.of(name));
    }

}