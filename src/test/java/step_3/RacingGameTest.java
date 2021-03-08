package step_3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Racing Game Test")
public class RacingGameTest {

    @DisplayName("Required Arguments Test")
    @Test
    void argumentsViolation() {
        assertThatNullPointerException()
                .isThrownBy(() -> {
                    try {
                        new RacingGame.Builder()
                                .build();
                    } catch (NullPointerException exception) {
                        throw new NullPointerException("Must Required At Two Arguments");
                    }
                })
                .withMessage("Must Required At Two Arguments")
                .withNoCause();
    }

    @DisplayName("Standby State Check")
    @Test
    void standByStateCheck() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        RacingResult racingResult = new RacingGame.Builder()
                .enterCars(3)
                .execution(4)
                .build()
                .standby();
        Constructor<RacingResult> racingResultConstructor = RacingResult.class.getDeclaredConstructor(List.class, Boolean.class);
        assertTrue(Modifier.isPrivate(racingResultConstructor.getModifiers()));
        racingResultConstructor.setAccessible(true);
        RacingResult differentRacingResult = racingResultConstructor.newInstance(new ArrayList<>(Arrays.asList(0, 0, 0)), false);
        assertThat(racingResult)
                .isEqualToComparingFieldByFieldRecursively(differentRacingResult);
    }

    @DisplayName("Racing History Size Check")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8})
    void racingCompleteCheck(int initializeLaps) {
        List<RacingResult> racingResults = new RacingGame.Builder()
                .enterCars(3)
                .execution(initializeLaps)
                .build()
                .startRacing();

        assertThat(initializeLaps)
                .isEqualTo(racingResults.size() - 1);
    }

}
