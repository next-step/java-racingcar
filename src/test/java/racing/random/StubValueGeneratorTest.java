package racing.random;

import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

class StubValueGeneratorTest {

    private int fixedNumber = 5;
    private StubValueGenerator stubValueGenerator = new StubValueGenerator(fixedNumber);

    @RepeatedTest(value = 100, name = "고정된 숫자를 리턴하는 StubRandomGenerator 검증 - {currentRepetition}")
    void getRandomIntValue() {

        assertThat(stubValueGenerator.generateIntValue()).isEqualTo(fixedNumber);
    }
}