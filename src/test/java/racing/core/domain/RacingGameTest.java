package racing.core.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import racing.core.dto.Trial;
import racing.core.exception.ErrorMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class RacingGameTest {

    private String[] namesOfCars = {"test1", "test2", "test3"};
    private int numberOfTrials = 3;

    @Test
    @DisplayName("생성자 테스트")
    void createRacingGame() {
        RacingGame racingGame = new RacingGame(namesOfCars, numberOfTrials);
        assertNotNull(racingGame);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("Null, 빈 문자열 전달 시 생성자 테스트")
    void createRacingGameWithNullOrEmptyName(String value) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            RacingGame racingGame = new RacingGame(new String[]{value}, numberOfTrials);
        }).withMessage(ErrorMessage.NULL_OR_EMPTY_VALUE.getMessage());
    }

    @Test
    @DisplayName("모든 차가 전혀 이동하지 경우 테스트")
    void runNever() {
        // given
        List<Trial> expected = new ArrayList<>(numberOfTrials);
        for (int i = 0; i < numberOfTrials; i++) {
            expected.add(new Trial(getCars(0)));
        }

        // when
        List<Trial> actual = new RacingGame(namesOfCars, expected.size()).run(() -> false);

        // then
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("모든 차가 항상 이동한 경우 테스트")
    void runAlways() {
        // given
        List<Trial> expected = new ArrayList<>(numberOfTrials);
        for (int i = 0; i < numberOfTrials; i++) {
            expected.add(new Trial(getCars(i + 1)));
        }

        // when
        List<Trial> actual = new RacingGame(namesOfCars, expected.size()).run(() -> true);

        // then
        assertEquals(expected, actual);
    }

    private Cars getCars(int position) {
        List<Car> cars = Arrays.stream(namesOfCars)
                .map(name -> new Car(name, position))
                .collect(Collectors.toList());
        return Cars.of(cars);
    }
}
