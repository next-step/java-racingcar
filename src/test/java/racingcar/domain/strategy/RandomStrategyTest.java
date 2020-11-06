package racingcar.domain.strategy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RandomStrategyTest {

    private RandomStrategy strategy;

    @BeforeEach
    void setUp() {
        strategy = RandomStrategy.getInstance();
    }

    @ParameterizedTest
    @DisplayName("4 이상 숫자만 true 가 되어야 한다.")
    @CsvSource(value = {"0:false", "1:false", "2:false", "3:false", "4:true", "5:true", "6:true", "7:true", "8:true", "9:true"}, delimiter = ':')
    void checkMovable(int randomNum, boolean expectedMovable) {
        boolean isMovable = strategy.checkMovable(randomNum);
        assertThat(isMovable)
                .isEqualTo(expectedMovable);
    }
}
