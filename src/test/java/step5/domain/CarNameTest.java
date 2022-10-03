package step5.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarNameTest {

    @Test
    @DisplayName("")
    void createCarNameSuccess() {
        CarName carName = new CarName("test");
        assertThat(carName.getName())
                .isEqualToIgnoringCase("test");
    }

    @Test
    @DisplayName("")
    void createCarNameFailByMoreThanFiveCharacters() {
        assertThatThrownBy(
                () -> new CarName("anakin"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("")
    void createCarNameFailByEmptyInput() {
        assertThatThrownBy(
                () -> new CarName(""))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
