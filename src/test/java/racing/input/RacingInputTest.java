package racing.input;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import racing.Car;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class RacingInputTest {
    @Test
    void inputNameTest() {
        //given
        String names = "pobi,crong,honux";
        InputStream inputStream = new ByteArrayInputStream(names.getBytes(StandardCharsets.UTF_8));
        RacingInput racingInput = new RacingInput(inputStream);

        //when
        List<Car> cars = racingInput.inputName();

        //then
        assertThat(cars.size()).isEqualTo(3);
        assertThat(cars.get(0).getName()).isEqualTo("pobi");
        assertThat(cars.get(1).getName()).isEqualTo("crong");
        assertThat(cars.get(2).getName()).isEqualTo("honux");
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
