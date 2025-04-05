package carrace.rules;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RandomValueTest {

    @DisplayName("0 이상 10 미만의 랜덤값이 나와야합니다.")
    @Test
    public void generateTest() {
        int randomValue = CarRaceRules.generateRandomValue();
        assertThat(randomValue).isBetween(0, 10);
    }
}
