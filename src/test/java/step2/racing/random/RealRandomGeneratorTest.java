package step2.racing.random;

import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

class RealRandomGeneratorTest {

    private final int bound = 10;
    private RealRandomGenerator realRandomGenerator = new RealRandomGenerator(bound);

    @RepeatedTest(value = 100, name = "랜덤 값이 0 이상이고 bound 이하인지 {totalRepetitions}번 검증 - {currentRepetition}")
    void getRandomIntValue() {

        assertThat(realRandomGenerator.getRandomIntValue())
                .isGreaterThanOrEqualTo(0)
                .isLessThan(bound);
    }
}