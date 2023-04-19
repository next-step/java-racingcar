package step3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step3.utils.RandomNumberGenerator;

public class RandomNumberGeneratorTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5})
    void 입력된_숫자가_generator의_결과로_출력(int input) {
        RandomNumberGenerator random = new RandomNumberGenerator();
    }
}
