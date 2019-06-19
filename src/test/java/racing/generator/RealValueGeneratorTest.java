package racing.generator;

import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

class RealValueGeneratorTest {

    private final int bound = 10;
    private RandomValueGenerator randomValueGenerator = new RandomValueGenerator(bound);

    @RepeatedTest(value = 100, name = "랜덤 값이 0 이상이고 bound 이하인지 {totalRepetitions}번 검증 - {currentRepetition}")
    void getRandomIntValue() {

        assertThat(randomValueGenerator.generateIntValue())
                .isGreaterThanOrEqualTo(0)
                .isLessThan(bound);
    }
}