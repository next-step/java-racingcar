package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step4.dto.Car;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class JudgeRacingResultTest {

    @ParameterizedTest
    @CsvSource(value = {"vita:2:clean:3:1","clean:3:hJang:3:2"}, delimiter = ':')
    @DisplayName("참여자들의 우승리스트 판단 테스트")
    void showWinnerTest(String entry1Name,int entry1finishPosition,String entry2Name,int entry2finishPosition,int winnerCount){
        Car car1 = Car.participateRacing(entry1Name, entry1finishPosition);
        Car car2 = Car.participateRacing(entry2Name, entry2finishPosition);
        List<Car> entryList = new ArrayList<>();
        entryList.add(car1);
        entryList.add(car2);

        JudgeRacingResult judgeRacingResult = new JudgeRacingResult();
        List winnerInRaceResult = judgeRacingResult.getWinnerInRaceResult(entryList);

        assertThat(winnerInRaceResult).hasSize(winnerCount);
    }
}