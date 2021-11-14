package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.model.Name;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class NameTest {
    @Test
    @DisplayName("car 만들 때 name 이 잘 들어가는지 테스트")
    void nameTest() {
        Name name = new Name("mj");
        Name name2 = new Name("mj");
        assertEquals(name, name2);
    }

    @Test
    @DisplayName("이름이 5 이상일 때 exception 테스트")
    void nameValidationTest() {
        assertThatThrownBy(() ->{
            Name name = new Name("sdfsfd");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름의 길이가 5가 넘습니다.");
    }
}
