package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.Name;

import static org.assertj.core.api.Assertions.assertThat;

public class NameTest {
    @Test
    @DisplayName("설정한 이름으로 Name 객체 생성")
    public void NameCreationTest() {
        Name name = new Name("테스트");
        assertThat(name.getName()).isEqualTo("테스트");
    }
}
