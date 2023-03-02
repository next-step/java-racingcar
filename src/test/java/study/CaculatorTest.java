package study;

import caculator.Caculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CaculatorTest {
    @ParameterizedTest
    @ValueSource(strings = {"2 + 3 * 4 / 2", "2 + 8 / 5 * 2"})
    void caculator(final String string) {
        Caculator cal = new Caculator();
        System.out.println(cal.caculator(string));
    }
}
