package car;

import car.domain.Name;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {

    @Test
    void 이름_생성_오류_테스트() {

        assertThatThrownBy(() -> {
            new Name("");
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("이름은");

        assertThatThrownBy(() -> {
            new Name("invalid name");
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("1 ~ 5");
    }

    @Test
    void 이름_생성_테스트() {
        Name name = new Name("test");

        assertThat(name.carName()).isEqualTo("test");
    }

}
