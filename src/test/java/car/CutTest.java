package car;

import car.domain.Cut;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CutTest {
    private Cut cut;

    @BeforeEach
    void setUp() {
        cut = new Cut();
    }

    @ParameterizedTest
    @ValueSource(strings = {"abcdefghijk"})
    void getCar(String input) {
        String actual = "abcde";
        String expected = cut.getCar(input).getName();

        assertThat(actual).isEqualTo(expected);
    }

}
