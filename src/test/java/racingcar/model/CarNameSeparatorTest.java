package racingcar.model;

import org.junit.jupiter.api.Test;
import racingcar.view.CarNameSeparator;

import static org.assertj.core.api.Assertions.assertThat;

public class CarNameSeparatorTest {

    @Test
    public void separateNamesComma() {
        assertThat(CarNameSeparator.separate("apple,boost,banana"))
                .containsExactly("apple", "boost", "banana");
    }
}
