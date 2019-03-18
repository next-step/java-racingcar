package racing.model;

import org.junit.*;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

public class NamedRacingCarTest extends RacingCarTest {

    @Test
    public void test_변환_이름() {
        String name = "pobi";
        RacingCar car = new NamedRacingCar(name);

        assertThat(car.toString()).isEqualTo(name);
    }

    @Test
    public void test_복사_동일성() {
        RacingCar car = new NamedRacingCar("pobi");
        RacingCar copy = car.clone();

        assertThat(car.toString())
                .isEqualTo(copy.toString());
        assertThat(car)
                .isNotSameAs(copy);
    }
}