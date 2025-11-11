package racingGame.model;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class RulesTest {
    
    @ParameterizedTest
    @ValueSource(ints = {0, -1, -2, -3})
    void moveSetTest(int num) {
        assertThatThrownBy(() -> {
            new Rules(num);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("%s", "이동횟수에 입력이 생략되거나, 0이하");
    }
    
    @ParameterizedTest
    @CsvSource(value = {"1:1", "2:2", "3:3", "3:5", "5:3"}, delimiter = ':')
    void ruesSetTest(int cars, int move) {
        assertThat(new Rules(cars)).isNotNull();
    }


    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    void checkLimitMoveTest(int moves) {
        Rules rules = new Rules(moves);
        assertThat(rules.isLimitMove(moves + 1)).isFalse();
    }

    
}