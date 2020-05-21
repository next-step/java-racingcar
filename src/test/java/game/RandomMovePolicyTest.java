package game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.Field;
import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

class RandomMovePolicyTest {

    @DisplayName("0~3 까지의 숫자는 정지, 4~9 까지의 숫자는 1칸 이동한다")
    @ParameterizedTest
    @MethodSource("source_verify_numberOfMove_shouldSucceed")
    public void verify_randomMovePolicy_shouldSucceed(int randomNumber, boolean expected) throws NoSuchFieldException, IllegalAccessException {
        MovePolicy movePolicy = new RandomMovePolicy();
        Random mockRand = new Random() {
            @Override
            public int nextInt(int bound) {
                return randomNumber;
            }
        };
        Field field = RandomMovePolicy.class.getDeclaredField("rand");
        field.setAccessible(true);
        field.set(movePolicy, mockRand);
        assertThat(movePolicy.isMovable()).isEqualTo(expected);
    }

    private static Stream<Arguments> source_verify_numberOfMove_shouldSucceed() {
        return Stream.of(
                Arguments.of(0, false),
                Arguments.of(3, false),
                Arguments.of(4, true),
                Arguments.of(9, true)
        );
    }
}
