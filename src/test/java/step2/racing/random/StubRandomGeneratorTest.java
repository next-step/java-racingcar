package step2.racing.random;

import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

class StubRandomGeneratorTest {

    private int fixedNumber = 5;
    private StubRandomGenerator stubRandomGenerator = new StubRandomGenerator(fixedNumber);

    @RepeatedTest(value = 100, name = "고정된 숫자를 리턴하는 StubRandomGenerator 검증 - {currentRepetition}")
    void getRandomIntValue() {

        assertThat(stubRandomGenerator.getRandomIntValue()).isEqualTo(fixedNumber);
    }
}