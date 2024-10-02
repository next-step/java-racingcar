package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SystemRandomHolderTest {
    private SystemRandomHolder systemRandomHolder;

    @BeforeEach
    void setUp() {
        systemRandomHolder = new SystemRandomHolder();
    }

    @Test
    @DisplayName("0 이상 9 이하의 랜덤 숫자를 반환한다.")
    void getNumber() {
        assertThat(systemRandomHolder.getNumber()).isBetween(0, 9);
    }
}
