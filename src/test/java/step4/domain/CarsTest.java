package step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.RecordDto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DisplayName("자동차 일급 컬렉션 테스트")
public class CarsTest {

    RandomRacingStrategy racingStrategy = new RandomRacingStrategy();

    @DisplayName("자동차 이동 기록")
    @Test
    public void getRecords() {
        Car car1 = mock(Car.class);
        Car car2 = mock(Car.class);
        int stepCount = 3;
        when(car1.getRecordCount()).thenReturn(stepCount);
        for (int step = 0; step < stepCount; step++) {
            when(car1.getRecordAtStep(step)).thenReturn(new RecordDto("", step + 1));
            when(car2.getRecordAtStep(step)).thenReturn(new RecordDto("", step));
        }
        Cars cars = Cars.of(Arrays.asList(car1, car2));

        List<List<RecordDto>> records = cars.getRecords();

        assertThat(records).contains(Arrays.asList(new RecordDto("", 1), new RecordDto("", 0)),
                Arrays.asList(new RecordDto("", 2), new RecordDto("", 1)),
                Arrays.asList(new RecordDto("", 3), new RecordDto("", 2)));
    }

    @DisplayName("자동차가 하나도 없을 때 기록")
    @Test
    public void getRecordsWithEmptyCars() {
        Cars cars = Cars.of(new ArrayList<>());

        assertThatThrownBy(cars::getRecords)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("no car");
    }

    @DisplayName("자동차 우승자 기록")
    @Test
    public void getWinnerRecords() {
        Car winner1 = mock(Car.class);
        Car winner2 = mock(Car.class);
        Car loser = mock(Car.class);
        when(winner1.getFinalRecord()).thenReturn(new RecordDto("winner1", 2));
        when(winner2.getFinalRecord()).thenReturn(new RecordDto("winner2", 2));
        when(loser.getFinalRecord()).thenReturn(new RecordDto("loser", 0));
        Cars cars = Cars.of(Arrays.asList(winner1, winner2, loser));

        List<RecordDto> winnerRecords = cars.getWinnerRecord();

        assertThat(winnerRecords).containsOnly(new RecordDto("winner1", 2),
                new RecordDto("winner2", 2));
    }
}