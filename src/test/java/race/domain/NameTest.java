package race.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NameTest {

    @Test
    @DisplayName("차 이름이 빈값 또는 공백이면 exception 발생")
    void carNameIsBlank() {
        String emptyString = "";
        assertThatThrownBy(() -> new Name(emptyString)).isInstanceOf(
            IllegalArgumentException.class);

        String spaceString = " ";
        assertThatThrownBy(() -> new Name(spaceString)).isInstanceOf(
            IllegalArgumentException.class);
    }

    @Test
    @DisplayName("차 이름이 5글자 이상이면 exception 발생")
    void carNameIsOverFive() {
        String longName = "aaaaaa"; // 6글자
        assertThatThrownBy(() -> new Name(longName)).isInstanceOf(
            IllegalArgumentException.class);
    }
}