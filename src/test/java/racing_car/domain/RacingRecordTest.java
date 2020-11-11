package racing_car.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;


class RacingRecordTest {

    @DisplayName("우승자 이름 추출 테스트 -  우승자 1명")
    @Test
    public void test() {
        //given
        List<Record> recordList = new ArrayList<>();
        recordList.add(new Record("철수", 1));
        recordList.add(new Record("자바", 2));
        recordList.add(new Record("영희", 3));
        recordList.add(new Record("파이썬", 4));
        LabRecord labRecord = new LabRecord(recordList);

        RacingRecord racingRecord = new RacingRecord(Arrays.asList(labRecord));

        //when
        List<String> finalLabWinnersName = racingRecord.getFinalLabWinnersName();

        //then

        assertAll(
                () -> assertThat(finalLabWinnersName.size()).isEqualTo(1),
                () -> assertThat(finalLabWinnersName.get(0)).isEqualTo("파이썬")
        );

    }

    @DisplayName("우승자 이름 추출 테스트 -  우승자 복")
    @Test
    public void test2() {
        //given
        List<Record> recordList = new ArrayList<>();
        recordList.add(new Record("철수", 1));
        recordList.add(new Record("자바", 2));
        recordList.add(new Record("영희", 4));
        recordList.add(new Record("파이썬", 4));
        LabRecord labRecord = new LabRecord(recordList);

        RacingRecord racingRecord = new RacingRecord(Arrays.asList(labRecord));

        //when
        List<String> finalLabWinnersName = racingRecord.getFinalLabWinnersName();

        //then

        assertAll(
                () -> assertThat(finalLabWinnersName.size()).isEqualTo(2),
                () -> assertThat(finalLabWinnersName).contains("파이썬"),
                () -> assertThat(finalLabWinnersName).contains("영희")
        );

    }
}
