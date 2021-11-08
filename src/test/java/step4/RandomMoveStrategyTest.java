package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RandomMoveStrategyTest {

    @DisplayName("move condition의 값과 나오는 값에 따라 True / False가 반환 된다.")
    @ParameterizedTest
    @CsvSource(value = {"4:4:true", "4:5:true", "4:3:false"}, delimiter = ':')
    void randomTest(int moveCondition, int returnItem, boolean result) {
        MoveStrategy moveStrategy = new RandomMoveStrategy(moveCondition, () -> returnItem);

        assertThat(moveStrategy.test()).isEqualTo(result);
    }

}