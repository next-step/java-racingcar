package study.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    @DisplayName("랜덤 값을 생성할 때 범위내에 존재하는지 테스트")
    @Test
    public void generateNumber_random_범위내에_있는지_테스트() {

        assertThat(GenerateNumber.random()).isGreaterThanOrEqualTo(0).isLessThanOrEqualTo(9);
    }
}
