package step3.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @DisplayName("RacingGame 객체의 인스턴스 변수에 사용자 입력값을 저장하는 Test")
    @ParameterizedTest
    @MethodSource("mockSaveUserInput")
    public void testIfUserInputIsSavedInRacingGameObject(HashMap<String, Integer> inputMap) {
        RacingGame racingGame = new RacingGame();
        racingGame.saveUserInput(inputMap);
        assertThat(racingGame.getGameTryCounts()).isEqualTo(inputMap.get("gameTryCounts"));
        assertThat(racingGame.getCarPositions().length).isEqualTo(inputMap.get("numberOfCars"));
    }

    private static Stream<Arguments> mockSaveUserInput() {
        HashMap<String, Integer> mockMapFirst = new HashMap<>();
        mockMapFirst.put("gameTryCounts", 10);
        mockMapFirst.put("numberOfCars", 15);
        HashMap<String, Integer> mockMapSecond = new HashMap<>();
        mockMapSecond.put("gameTryCounts", 13);
        mockMapSecond.put("numberOfCars", 19);
        return Stream.of(
                Arguments.of(mockMapFirst),
                Arguments.of(mockMapSecond)
        );
    }

}
