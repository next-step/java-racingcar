package carracingwinner.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {

    @Test
    void validateNameOkTest() {
        String okName = "pobi";

        Name okCar = new Name(okName);

        assertThat(okCar.getName()).isEqualTo(okName);
    }

    @Test
    void validateNameFailTest() {
        String failName = "pobi!!";

        assertThatThrownBy(() -> new Name(failName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 ")
                .hasMessageContaining("자를 초과할 수 없습니다.");
    }

}
