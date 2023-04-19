package study.race;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import study.race.condition.RaceConditionNumber;

public class TestCarRaceSimple {

    class SuccessCondition implements RaceConditionNumber {
        @Override
        public int fetch() {
            return 4;
        }
    }

    class FailCondition implements RaceConditionNumber {
        @Override
        public int fetch() {
            return 2;
        }
    }

    private String[] splitForTest(String givenString) {
        String splitChar = ",";
        return givenString.split(splitChar);
    }


    @Test
    @DisplayName("CarRace 초기화 후 ready() 함수 미실행 테스트")
    public void test_race_ready_fail() {
        RaceConditionNumber successNumber = new SuccessCondition();
        CarRace race = new CarRace(successNumber);

        assertThrows(IllegalStateException.class, () -> {
            race.run();
        });
    }


    @ParameterizedTest(name = "CarRace 입력 CarEntry 개수 입력 테스트")
    @CsvSource({
        "'pobi,honux', 4", 
        "'pobi,crong,honux,elsa', 5", 
        "'pobi,crong,honux', 6"
    })
    public void test_carrace_carNum_tryNum_input(String entryNum, int raceNum) {
        String[] entryNums = splitForTest(entryNum);

        RaceConditionNumber successNumber = new SuccessCondition();
        CarRace race = new CarRace(successNumber);
        race.ready(entryNums, raceNum);

        assertThat(race.getRaceResult().size()).isEqualTo(entryNums.length);
    }


    @ParameterizedTest(name = "CarRace 실행 테스트")
    @CsvSource({
        "'pobi,honux', 4", 
        "'pobi,crong,honux,elsa', 5", 
        "'pobi,crong,honux', 6"
    })
    public void test_carrace_run(String entryNum, int raceNum) {
        String[] entryNums = splitForTest(entryNum);

        RaceConditionNumber failNumber = new FailCondition();
        CarRace race = new CarRace(failNumber);
        race.ready(entryNums, raceNum);
        race.run();

        for (CarEntry entry : race.getRaceResult()) {
            assertThat(entry.getMoveRecord().size()).isEqualTo(raceNum);
        }
    }


    @Test
    @DisplayName("CarRace run() 함수 미실행 우승자 테스트")
    public void test_carrace_not_run_test() {
        int raceNum = 4;
        String[] entryNums = splitForTest("pobi,honux");

        RaceConditionNumber successNumber = new SuccessCondition();
        CarRace race = new CarRace(successNumber);
        race.ready(entryNums, raceNum);

        assertThrows(IllegalStateException.class, () -> {
            race.winner();
        });
    }


    @ParameterizedTest(name = "CarRace 우승자 테스트")
    @CsvSource({
        "'pobi,honux', 4",
        "'pobi,crong,honux,elsa', 5", 
        "'pobi,crong,honux', 6"
    })
    public void test_carrace_winner(String entryNum, int raceNum) {
        String[] entryNums = splitForTest(entryNum);

        RaceConditionNumber successNumber = new SuccessCondition();
        CarRace race = new CarRace(successNumber);
        race.ready(entryNums, raceNum);
        race.run();

        assertThat(race.winner().size()).isEqualTo(entryNums.length);
    }

}
