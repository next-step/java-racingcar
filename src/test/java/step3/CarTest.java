package step3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step3.domain.Car;
import step3.domain.Position;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {

    private static final int NOT_MOVED = 0;
    private static final int MOVED = 1;
    private static final String NAME = "pobi";

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    public void 자동차_전진_실패(int random) {
        Car car = new Car(NAME);
        car.move(random);
        Position position = car.position();
        assertThat(position.position()).isEqualTo(NOT_MOVED);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    public void 자동차_전진_성공(int random) {
        Car car = new Car(NAME);
        car.move(random);
        Position position = car.position();
        assertThat(position.position()).isEqualTo(MOVED);
    }

}
