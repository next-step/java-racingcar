package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class CarNamesTest {

    @Test
    void create() {
        CarNames carNames = new CarNames(
                Arrays.asList(
                        new CarName("ruby"),
                        new CarName("pobi"),
                        new CarName("shine")
                )
        );
        assertThat(carNames.getCarNames()).contains(
                new CarName("ruby"),
                new CarName("pobi"),
                new CarName("shine"));
    }

}
