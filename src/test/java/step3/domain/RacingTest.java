package step3.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {

    private Racing racing;

    @BeforeEach
    void setUp() {
        racing = new Racing();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 4, 6})
    @DisplayName("차량 객체 생성 테스트 코드")
    void carRegistration(int count) {
        assertThat(racing.carRegistration(count)).size().isEqualTo(count);
    }
}
