package racinggame.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NamesAsCarsTest {
    @Test
    void cars() {
        NamesAsCars namesAsCars = new NamesAsCars(new StringAsNames("pobi,crong"));
        assertThat(namesAsCars.cars()).containsExactly(new Car("pobi"), new Car("crong"));
    }
}
