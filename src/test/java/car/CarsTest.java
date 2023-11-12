package car;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class CarsTest {

    private final InputParser inputParser = new InputParser();

    @Test
    public void 자동차_생성_테스트() {
        List<Car> expected = new ArrayList<>();
        expected.add(new Car("pobi"));
        expected.add(new Car("crong"));

        Cars cars = new Cars(inputParser.parseUserInputByDelimiter("pobi,crong"));

        assertThat(cars.getCars()).isEqualTo(expected);
    }
}
