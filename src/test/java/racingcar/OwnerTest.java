package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.Owner;

import static org.assertj.core.api.Assertions.assertThat;

public class OwnerTest {

    @Test
    void create() {
        Owner owner = new Owner("pobi");
        assertThat(owner).isNotNull();
    }
}
