package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class GameRoleTest {
    private GameRole gameRole;

    @BeforeEach
    void setUp() {
        this.gameRole = new GameRole(1);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:0", "2:0", "3:0", "4:1", "5:1", "6:1", "7:1"}, delimiter = ':')
    void getAdvanceCount(int value, int expected) {
        assertThat(gameRole.getAdvanceCount(value)).isEqualTo(expected);
    }
}
