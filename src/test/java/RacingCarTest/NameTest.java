package RacingCarTest;

import org.junit.jupiter.api.Test;
import racingcar.Name;
import racingcar.SimpleCar;

import static org.assertj.core.api.Assertions.*;

public class NameTest {
    @Test
    void Given_InitialName_When_New_Then_Created() {
        String initialName = "Name";

        Name name = new Name(initialName);

        assertThat(name).isEqualTo(new Name(initialName));
    }

    @Test
    void Given_LongName_When_New_Then_IllegalAruementException() {
        String longName = "LongCarName";

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Name(longName);
                });
    }
}
