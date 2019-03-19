package racing.model;

import org.junit.*;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

public class NamedRacingCarTest extends RacingCarTest {

    @Test
    public void test_변환_이름() {
        String name = "pobi";
        NamedRacingCar car = new NamedRacingCar(name);

        assertThat(car).hasToString(name);
    }

    @Test
    public void test_복사_참조_불일치() {
        NamedRacingCar origin = new NamedRacingCar("pobi");
        NamedRacingCar copy = origin.copy();

        assertThat(origin)
                .isNotSameAs(copy);
    }

    @Test
    public void test_복사_이름_일치() {
        NamedRacingCar origin = new NamedRacingCar("pobi");
        NamedRacingCar copy = origin.copy();

        assertThat(origin.toString())
                .isEqualTo(copy.toString());
    }
}