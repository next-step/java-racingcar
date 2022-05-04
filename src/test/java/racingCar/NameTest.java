package racingCar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {
    @Test
    void 이름공백예외처리(){
        assertThatThrownBy(() -> {
            Name name = new Name("");
        }).isInstanceOf(IllegalStateException.class);
    }

    @Test
    void 이름글자수예외처리(){
        assertThatThrownBy(() -> {
            Name name = new Name("123456");
        }).isInstanceOf(IllegalStateException.class);
    }
}
