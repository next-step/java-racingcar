package racingGame;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarNameTest {

    @Test
    @DisplayName("앞뒤 공백은 제거되고, 유효한 이름이면 생성에 성공한다")
    void trimAndCreate_whenValidName() {
        CarName name = new CarName("  pobi  ");

        assertThat(name.value()).isEqualTo("pobi");
    }

    @Test
    @DisplayName("null 또는 빈 문자열, 공백만 있는 문자열은 예외가 발생한다")
    void nullOrBlank_throwsException() {
        assertThatThrownBy(() -> new CarName(null))
            .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new CarName(""))
            .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new CarName("   "))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이름이 5자를 초과하면 예외가 발생한다")
    void nameLongerThanFive_throwsException() {
        assertThatThrownBy(() -> new CarName("abcdef"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("동일한 문자열을 가진 CarName은 equals/hashCode가 같다")
    void equalsAndHashCode() {
        CarName name1 = new CarName("pobi");
        CarName name2 = new CarName("pobi");

        assertThat(name1).isEqualTo(name2);
        assertThat(name1.hashCode()).isEqualTo(name2.hashCode());
    }
}
