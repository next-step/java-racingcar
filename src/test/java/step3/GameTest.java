package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    private Game game;

    @BeforeEach
    void init() {
        game = new Game();
    }

    private Object invokePrivateMethod(Object targetObject, String methodName)
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method privateMethod = targetObject.getClass().getDeclaredMethod(methodName);

        privateMethod.setAccessible(true);

        return privateMethod.invoke(targetObject);
    }

    @Test
    @DisplayName("go, stop 케이스 모두 발생하는지 테스트")
    void goOrStop() {
        HashSet<TURN> set = new HashSet<>();

        IntStream.range(0, 100)
                .forEach((i) -> {
                    try {
                        set.add((TURN)invokePrivateMethod(game, "goOrStop"));
                    } catch (NoSuchMethodException |InvocationTargetException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                });

        assertThat(set.size()).isEqualTo(2);
    }
}
