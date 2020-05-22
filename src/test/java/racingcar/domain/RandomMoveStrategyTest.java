package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Random;

@ExtendWith(MockitoExtension.class)
class RandomMoveStrategyTest {

    @Mock
    private Random random = new Random();

    @InjectMocks
    private RandomMoveStrategy randomMoveStrategy;

    @DisplayName("랜덤 숫자가 4 미만일 경우 움직일 수 없다")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void randomNumberLessThan5_Then_canMove(int randomNumber) {
        Mockito.when(random.nextInt(10)).thenReturn(randomNumber);
        Assertions.assertThat(randomMoveStrategy.canMove()).isFalse();
    }

    @DisplayName("랜덤 숫자가 4 이상일 경우 움직일 수 있다")
    @ParameterizedTest
    @ValueSource(ints = {5, 6, 7, 8, 9})
    void randomNumberLessThan5_Then_cantMove(int randomNumber) {
        Mockito.when(random.nextInt(10)).thenReturn(randomNumber);
        Assertions.assertThat(randomMoveStrategy.canMove()).isTrue();
    }
}
