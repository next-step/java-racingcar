package racingcar.domain;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import racingcar.ui.view.MotorRacingDisplayResults;

import static org.assertj.core.api.Assertions.assertThat;

public class MotorRacingTest {
    @DisplayName("선택한 차량별로 모두 전진했을 때, 예상 처리결과 확인")
    @ParameterizedTest
    @CsvSource(value={
          "3,1,-\\n-\\n-"
        , "3,2,-\\n-\\n-\\n\\n--\\n--\\n--"
        , "3,3,-\\n-\\n-\\n\\n--\\n--\\n--\\n\\n---\\n---\\n---"
    })
    void inputWithCount(int carCount, int raceRound, String expected){
        MotorRacingRule positiveMotorRacingRule = () -> true;
        MotorRacing motorRacing = new MotorRacing(carCount, positiveMotorRacingRule);
        MotorRacingDisplayResults motorRacingDisplayResults = motorRacing.racing(raceRound);
        String result = motorRacingDisplayResults.toString();
        assertThat(result.replace("\n", "\\n")).isEqualTo(expected);
    }

    @DisplayName("이름을 가진 차량별로 모두 전진했을 때, 예상 처리결과 확인")
    @ParameterizedTest
    @CsvSource(value={
        "a|b|c,1," +
            "a : -\\n" +
            "b : -\\n" +
            "c : -"
        , "aa|bb|cc,2," +
            "aa : -\\n" +
            "bb : -\\n" +
            "cc : -\\n\\n" +
            "aa : --\\n" +
            "bb : --\\n" +
            "cc : --"
        , "a|b|c,3," +
            "a : -\\n" +
            "b : -\\n" +
            "c : -\\n\\n" +
            "a : --\\n" +
            "b : --\\n" +
            "c : --\\n\\n" +
            "a : ---\\n" +
            "b : ---\\n" +
            "c : ---"
    })
    void inputWithCarNames(String cars, int raceRound, String expected){
        Set<String> carNames = Arrays.stream(cars.split("\\|"))
                                     .collect(Collectors.toCollection(LinkedHashSet::new))
            ;
        MotorRacingRule positiveMotorRacingRule = () -> true;
        MotorRacing motorRacing = new MotorRacing(carNames, positiveMotorRacingRule);
        MotorRacingDisplayResults motorRacingDisplayResults = motorRacing.racing(raceRound);
        String result = motorRacingDisplayResults.toString();
        assertThat(result.replace("\n", "\\n")).contains(expected);
    }
}
