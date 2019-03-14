package racing.model;

import org.junit.*;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

public class NamedRacingCarTest extends RacingCarTest {

    @Test
    public void test_변환_이름() {
        String name = "pobi";
        NamedRacingCar namedRacingCar = new NamedRacingCar(name);
        assertThat(namedRacingCar.toString()).isEqualTo(name);
    }

    @Test
    public void test_복사_동일성() {
        NamedRacingCar namedRacingCar = new NamedRacingCar("pobi");
        NamedRacingCar copy = new NamedRacingCar(namedRacingCar);
        assertThat(namedRacingCar).isNotSameAs(copy);
    }
}