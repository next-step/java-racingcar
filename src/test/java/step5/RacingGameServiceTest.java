package step5;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step5.dto.CarNames;
import step5.domain.RaceRecordGroup;
import step5.dto.TrialCount;
import step5.domain.RacingGameService;

import java.util.Arrays;

class RacingGameServiceTest {

    @ParameterizedTest
    @CsvSource(value = {"poby,dy|2", "cat,dog,rian|3", "a,b,c|1", "test,tdd,code|5"}, delimiter = '|')
    @DisplayName("레이싱 시도 횟수만큼 경기 기록 그룹이 생성된다")
    public void recordCountTest(String name, int expected) {
        RacingGameService racingGameService = new RacingGameService();

        RaceRecordGroup recordGroup = racingGameService.raceStart(new CarNames(Arrays.asList(name.split(","))), new TrialCount(expected));

        Assertions.assertThat(recordGroup.getRaceRecordGroup()).hasSize(expected);
    }

}
