package race.car;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


public class RunCarRaceTest {

    private RunCarRace runCarRace = new RunCarRace();

    @ParameterizedTest
    @MethodSource("runRaceParameter")
    @DisplayName("자동차 이름 갯수에 따른 list 생성 테스트")
    void isCreationArr(String[] raceCarNames, int raceTryCount) {
        assertEquals(runCarRace.runRace(raceCarNames, raceTryCount).size(), raceCarNames.length);
    }


    @ParameterizedTest
    @MethodSource("runRaceParameter")
    @DisplayName("자동차 별 시도한 횟수가 제대로 들어가 있는지 테스트")
    void isCreationRaceTryCount(String[] raceCarNames, int raceTryCount) {
        HashMap<String, List<CarRaceMoveInfo>> carReacMoveInfoList = runCarRace.runRace(raceCarNames, raceTryCount);

        for (String carName : raceCarNames) {
            assertEquals(carReacMoveInfoList.get(carName).size(), raceTryCount);
        }
    }

    private static Stream<Arguments> runRaceParameter() { // argument source method
        return Stream.of(
                Arguments.of(new String[]{"player1", "player2"}, 6),
                Arguments.of(new String[]{"player1"}, 3),
                Arguments.of(new String[]{"player1", "player2", "player3"}, 2)
        );
    }
}
