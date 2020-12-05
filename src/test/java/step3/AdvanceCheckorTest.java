package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step3.domain.AdvanceCheckor;

import static org.assertj.core.api.Assertions.assertThat;

public class AdvanceCheckorTest {

    private AdvanceCheckor advanceCheckor;

    @BeforeEach
    void setUp() {
        advanceCheckor = new AdvanceCheckor();
    }

    @ParameterizedTest
    @CsvSource(value = {"0:false", "1:false", "4:true", "9:true"}, delimiter = ':')
    @DisplayName("4미만이면 false, 4이상이면 true")
    void check(int input, boolean expected) {
        assertThat(advanceCheckor.check(input)).isEqualTo(expected);
    }
}
