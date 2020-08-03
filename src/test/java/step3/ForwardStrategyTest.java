package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.BasicForwardStrategy;
import step3.domain.ForwardStrategy;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("이동전략 테스트")
public class ForwardStrategyTest {

    private ForwardStrategy forwardStrategy;

    @BeforeEach
    public void setUp() {
        forwardStrategy = new BasicForwardStrategy();
    }

    @Test
    @DisplayName("이동거리를 계산한다.")
    public void getPosition() {
        assertThat(forwardStrategy.calculateForwardDistance()).isIn(0, 1);
    }

}
