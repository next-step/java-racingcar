package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RandomMovableStrategyTest {

    RandomMovableStrategy randomMovable;

    @BeforeEach
    void setUp(){
        randomMovable = new RandomMovableStrategy();
    }

    @Test
    @DisplayName("움직임은 항상 1보다 작다.")
    void moveTest(){
        int result = randomMovable.move();
        assertThat(result).isLessThanOrEqualTo(1);
    }

    @CsvSource(value = {"5:1", "4:1", "3:0", "1:0"}, delimiter = ':')
    @ParameterizedTest
    @ExtendWith(MockitoExtension.class)
    @DisplayName("random 값을 예측하고 결과값을 검증한다.")
    void randomMoveTest(int returnValue, int expected){
        Random random = mock(Random.class);
        RandomMovableStrategy randomMovableStrategy = new RandomMovableStrategy(random);

        when(random.nextInt(10)).thenReturn(returnValue);

        assertThat(randomMovableStrategy.move()).isEqualTo(expected);
    }
}
