package racing.model;

import org.junit.*;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

public class NamedRacingCarTest extends RacingCarTest {

    @Test
    public void test_변환_이름() {
        String name = "pobi";
        NamedRacingCar car = new NamedRacingCar(name);

        assertThat(car.toString()).isEqualTo(name);
    }

    @Test
    public void test_복사_동일성_동일한타입() {
        RacingCar origin = new NamedRacingCar("pobi");
        RacingCar copy = NamedRacingCar.copy(origin);

        assertThat(origin.toString())
                .isEqualTo(copy.toString());
        assertThat(origin)
                .isNotSameAs(copy);
    }

    @Test
    public void test_복사_동일성_상위타입_베이스() {
        RacingCar origin = new RacingCar();
        RacingCar copy = NamedRacingCar.copy(origin);

        assertThat(origin.toString())
                .isEqualTo(copy.toString());
        assertThat(origin)
                .isNotSameAs(copy);
    }
}