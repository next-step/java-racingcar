package racing.model;

import org.junit.*;

import static org.assertj.core.api.Assertions.assertThat;

public class NamedRacingCarTest extends RacingCarTest {

    @Test
    public void test_변환_이름() {
        String name = "pobi";
        NamedRacingCar namedRacingCar = new NamedRacingCar(name);
        assertThat(namedRacingCar.toString()).isEqualTo(name);
    }
}