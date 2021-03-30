package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Owner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OwnerTest {

    @DisplayName("Owner 객체가 생성이 잘 되는지")
    @Test
    void create() {
        Owner owner = new Owner("pobi");
        assertThat(owner).isNotNull();
    }

    @DisplayName("Owner의 이름이 빈값인 경우")
    @Test
    void null_check() {
        assertThatThrownBy(() -> {
            new Owner("");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Owner의 이름이 5글자가 넘는 경우")
    @Test
    void over_length() {
        assertThatThrownBy(() -> {
            new Owner("pobipobi");
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
