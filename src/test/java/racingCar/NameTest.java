package racingCar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingCar.domain.Name;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {

    @Test
    void create() {
        Name name = new Name("pobi");
        assertThat(name.toString()).isEqualTo("pobi");
    }
    
    @Test
    void 이름공백예외처리() {
        assertThatThrownBy(() -> {
            Name name = new Name("");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름글자수예외처리() {
        assertThatThrownBy(() -> {
            Name name = new Name("123456");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
