package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.service.MoveStrategy;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RecordTest {
    @Test
    @DisplayName("record 가 정상적으로 생성되는지 테스트")
    void record() {
        //given
        final int carNumber = 3;
        MoveStrategy stubMoveStrategy = new StubMoveStrategy();
        Cars cars = new Cars(carNumber);
        cars.moveCars(stubMoveStrategy);
        final String expectString = "-";
        List<String> expectRecord = new ArrayList<>();

        for (int i = 0; i < carNumber; i++) {
            expectRecord.add(expectString);
        }


        //when
        Record resultRecord = new Record(cars);

        //then
        assertThat(resultRecord.getRecord()).isEqualTo(expectRecord);

    }


    public class StubMoveStrategy implements MoveStrategy {
        @Override
        public Boolean getIsMove() {
            return true;
        }
    }
}
