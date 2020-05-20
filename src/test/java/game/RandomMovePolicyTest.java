package game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

class RandomMovePolicyTest {

    @DisplayName("0~3 까지의 숫자는 정지, 4~9 까지의 숫자는 1칸 이동한다")
    @ParameterizedTest
    @MethodSource("source_verify_numberOfMove_shouldSucceed")
    public void verify_randomMovePolicy_shouldSucceed(int randomNumber, int position, int expected) {
        Random random = mock(Random.class);
        when(random.nextInt(anyInt())).thenReturn(randomNumber);

        Car car = new Car(position, new RandomMovePolicy(random));
        car.move();
        assertThat(car.getPosition()).isEqualTo(expected);
    }

    private static Stream<Arguments> source_verify_numberOfMove_shouldSucceed() {
        return Stream.of(
                Arguments.of(0, 1, 1),
                Arguments.of(3, 4, 4),
                Arguments.of(4, 5, 6),
                Arguments.of(9, 2, 3)
        );
    }
}
