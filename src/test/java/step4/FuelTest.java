package step4;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FuelTest {

    @Test
    void create() {
        Fuel fuel = new Fuel();
        assertThat(fuel).isEqualTo(new Fuel());
    }
}