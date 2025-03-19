package game;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

public class CarNamesTest {

    @DisplayName("공백으로 이름 불가")
    @ParameterizedTest(name = "공백으로 이름 불가:{0}")
    @ValueSource(strings = {"", " "})
    void constructor(String name) {
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> new CarNames(List.of(new CarName(name))));
    }

    @DisplayName("5자 초과 이름 불가")
    @Test
    void constructor_2() {
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> new CarNames(List.of(new CarName("123456"))));
    }


}
