package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class LapResultTest {

    @Test
    void 랩결과_자동차들() {
        List<Car> origin = Arrays.asList(new Car("1"), new Car("2"));
        LapResult lapResult = new LapResult(origin);
        assertThat(lapResult.cars()).isNotSameAs(origin);
    }

}
