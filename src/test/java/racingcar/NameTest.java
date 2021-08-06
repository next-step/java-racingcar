package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Name;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class NameTest {
    @Test
    @DisplayName("name 이 같으면 같은 객체")
    public void equals() {
        Name name = new Name("test");
        assertThat(name).isEqualTo(new Name("test"));
    }

    @Test
    @DisplayName("이름은 5자를 넘을 수 없음")
    public void nameLength() {
        assertThatThrownBy(() -> {
            new Name("123456");
        })
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("Car name 은 5자를 넘을 수 없습니다");
    }
}
