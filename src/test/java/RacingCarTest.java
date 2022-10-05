import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingCar.step3.RacingCar;
import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {
    private RacingCar car = new RacingCar(System.currentTimeMillis());

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void canMove_4보다_작은_수(int number) {
        assertThat(car.canMove(number)).isEqualTo(false);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void canMove_4보다_큰_수(int number) {
        assertThat(car.canMove(number)).isEqualTo(true);
    }

}