package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarNameSeparatorTest {

    @Test
    public void separateNamesComma() {
        assertThat(CarNameSeparator.separateNames("apple,boost,banana"))
                .containsExactly("apple", "boost", "banana");
    }
}
