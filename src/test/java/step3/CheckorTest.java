package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckorTest {

    Checkor checkor;

    @BeforeEach
    void setUp() {
        checkor = new Checkor();
    }

    @ParameterizedTest
    @CsvSource(value = {"0:false", "1:false", "4:true", "9:true"}, delimiter = ':')
    @DisplayName("4미만이면 false, 4이상이면 true")
    void check(int input, boolean expected) {
        assertThat(checkor.check(input)).isEqualTo(expected);
    }
}
