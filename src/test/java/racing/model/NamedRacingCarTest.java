package racing.model;

import org.junit.*;

import static org.assertj.core.api.Assertions.assertThat;

public class NamedRacingCarTest extends RacingCarTest {

    @Test
    @Override
    public void test_변환_DTO() {
        String name = "pobi";
        NamedRacingCar namedRacingCar = new NamedRacingCar(name);
        assertThat(namedRacingCar.mapToDto().getPosition()).isEqualTo(0);
        assertThat(namedRacingCar.mapToDto().getName()).isEqualTo(name);
    }
}