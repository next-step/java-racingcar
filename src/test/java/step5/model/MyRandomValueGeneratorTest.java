package step5.model;

import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

class MyRandomValueGeneratorTest {

    private final MyRandomValueGenerator myRandomValueGenerator = new MyRandomValueGenerator();

    @RepeatedTest(value = 100, name = "랜덤 값이 0 ~ 9 사이의 값이어야 합니다.")
    void generateRandomValue() {
        // when
        int result = myRandomValueGenerator.generateRandomValue();
        // then
        assertThat(result).isBetween(0, 9);
    }
}