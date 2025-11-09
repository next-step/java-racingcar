package racingGame.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class RulesTest {
    
    @ParameterizedTest
    @ValueSource(ints = {0, -1, -2, -3})
    void carSetTest(int num) {
        assertThatThrownBy(() -> {
            Rules.of(1, num);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("%s", "참가시킬 자동차 수 입력이 생략되거나, 0이하");
    }
    
    @ParameterizedTest
    @ValueSource(ints = {0, -1, -2, -3})
    void moveSetTest(int num) {
        assertThatThrownBy(() -> {
            Rules.of(num, 1);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("%s", "이동횟수에 입력이 생략되거나, 0이하");
    }
    
    @ParameterizedTest
    @CsvSource(value = {"1:1", "2:2", "3:3", "3:5", "5:3"}, delimiter = ':')
    void ruesSetTest(int move, int cars) {
        assertThat(Rules.of(move, cars)).isNotNull();
    }
    
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    void checkLimitMoveTest(int moves) {
        Rules rules = Rules.of(moves, 1);
        assertThat(rules.isLimitMove(moves + 1)).isFalse();
    }
    
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    void checkLimitCarsTest(int cars) {
        Rules rules = Rules.of(1, cars);
        assertThat(rules.isLimitCars(cars + 1)).isFalse();
    }
    
}