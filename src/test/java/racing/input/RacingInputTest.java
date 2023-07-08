package racing.input;

import org.junit.jupiter.api.Test;
import racing.domain.Car;
import racing.domain.CarCollection;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingInputTest {
    @Test
    void inputNameTest() {
        //given
        String names = "pobi,crong,honux";
        InputStream inputStream = new ByteArrayInputStream(names.getBytes(StandardCharsets.UTF_8));
        RacingInput racingInput = new RacingInput(inputStream);

        //when
        CarCollection cars = racingInput.inputName();

        //then
        assertThat(cars).isEqualTo(new CarCollection(List.of(
                new Car("pobi", 1),
                new Car("crong", 1),
                new Car("honux", 1)
        )));
    }

    @Test
    void inputCountTest() {
        //given
        String count = "5";
        InputStream inputStream = new ByteArrayInputStream(count.getBytes(StandardCharsets.UTF_8));
        RacingInput racingInput = new RacingInput(inputStream);

        //when
        int result = racingInput.inputCount();

        //then
        assertThat(result).isEqualTo(5);
    }
}
