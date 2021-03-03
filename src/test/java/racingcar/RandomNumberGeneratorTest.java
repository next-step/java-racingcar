package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.RandomNumberGenerator;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberGeneratorTest {

    @ParameterizedTest
    @CsvSource(value = {"0:9","1:3","1:12"}, delimiter = ':')
    @DisplayName("특정 범위내 숫자를 랜덤으로 생성하는지 테스트")
    void randomNumberGenerate(int min,int max) {
        int maxTryCount=100;
        RandomNumberGenerator numberGenerator = new RandomNumberGenerator(max,min);
        for (int i = 0; i < maxTryCount; i++) {
            int generatedNumber = numberGenerator.generate();
            assertThat(generatedNumber).isBetween(min,max);
        }

    }
}
