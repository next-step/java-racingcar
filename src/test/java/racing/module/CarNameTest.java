package racing.module;

import exception.EmptyCarNameException;
import exception.InvalidCarNameSizeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class CarNameTest {
    @Test
    @DisplayName("이름이 맞게 생성되었는지 확인")
    void getName() {
        CarName carName = new CarName("test");
        assertThat(carName.getName()).isEqualTo("test");
    }

    @Test
    @DisplayName("이름이 공백일때 Exception확인")
    void blankName() {
        assertThatThrownBy(() -> {
            CarName carName = new CarName("");
        }).isInstanceOf(EmptyCarNameException.class);
    }

    @Test
    @DisplayName("이름이 5글자가 넘을때 Exception확인")
    void overFiveLetterName() {
        assertThatThrownBy(() -> {
            CarName carName = new CarName("test66");
        }).isInstanceOf(InvalidCarNameSizeException.class);
    }
}