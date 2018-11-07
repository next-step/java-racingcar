package racing;

import org.junit.Test;
import racing.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
public class CarTest {

    @Test
    public void 차가_앞으로_가지_못하는_조건에서_차를_달리도록_하는_경우() {

        final Car car = new Car("Ryan", () -> false);

        for (int i = 0; i < 100; i++) {
            car.run();
        }

        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    public void 차가_앞으로_갈_수_있는_조건에서_차를_달리도록_하는_경우() {

        final Car car = new Car("Ryan", () -> true);

        for (int i = 0; i < 100; i++) {
            car.run();
        }

        assertThat(car.getPosition()).isEqualTo(100);
    }

}