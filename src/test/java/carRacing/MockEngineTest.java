package carRacing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MockEngineTest {

    @ParameterizedTest
    @CsvSource(value = {
            "2,2",
            "5,5",
            "10,10",
            "4,4"
    })
    public void getPowerOutputTest(int input, int expected) {
        MockEngine engine = new MockEngine(input);
        assertThat(engine.getPowerOutput()).isEqualTo(expected);
    }

}