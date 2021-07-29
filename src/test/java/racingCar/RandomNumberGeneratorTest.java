package racingCar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import racingCar.domain.RandomNumberGenerator;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberGeneratorTest {

    @DisplayName("랜덤으로 생성된 수가 0, 9 사이에 있는지 테스트")
    @RepeatedTest(20)
    void 랜덤_값_생성() {
        assertThat(RandomNumberGenerator.getRandomNumber()).isBetween(0, 9);
    }
}
