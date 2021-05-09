package car;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {
    @ParameterizedTest
    @ValueSource(strings = {"pobiwonijuni"})
    public void getCar(String carInput) {
        Cut cut = new Cut();
        Car car = cut.getCar(carInput);
        System.out.println(car.getName());
    }
}
