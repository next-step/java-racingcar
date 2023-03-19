package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DriverTest {

    @DisplayName("참가자 이름 검증(빈 값, null 값")
    @ParameterizedTest
    @NullAndEmptySource
    void emptyName(String name) {
        assertThrows(IllegalArgumentException.class, () -> {
           new Driver(name);
        });
    }

    @DisplayName("참가자의 이름 길이 초과")
    @ParameterizedTest
    @ValueSource(strings = {"charles", "carlos"})
    void exceedName(String name) {
        assertThrows(IllegalArgumentException.class, () -> {
            new Driver(name);
        });
    }
    
    @DisplayName("참가자 이름 확인")
    @ParameterizedTest
    @ValueSource(strings = {"LEC", "SAI"})
    void validName(String name) {
        Driver actual = new Driver(name);
        assertThat(actual.getName()).isEqualTo(name);
    }
}