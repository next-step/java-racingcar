package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.exception.InvalidCarCountException;
import racingcar.dto.RecordDto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DisplayName("자동차 일급 컬렉션 테스트")
public class CarsTest {

    @DisplayName("자동차 이동 기록")
    @Test
    public void getRecords() {
        Car car1 = mock(Car.class);
        Car car2 = mock(Car.class);
        when(car1.getRecord()).thenReturn(new RecordDto("car1", 2));
        when(car2.getRecord()).thenReturn(new RecordDto("car2", 3));
        Cars cars = Cars.of(Arrays.asList(car1, car2));

        List<RecordDto> records = cars.getRecords();

        assertThat(records).contains(new RecordDto("car1", 2), new RecordDto("car2", 3));
    }

    @DisplayName("자동차가 하나도 없을 때")
    @Test
    public void getRecordsWithEmptyCars() {
        assertThatThrownBy(() -> {
            Cars.of(new ArrayList<>());
        }).isInstanceOf(InvalidCarCountException.class)
                .hasMessageContaining("invalid car count");
    }

    @DisplayName("자동차 우승자 기록")
    @Test
    public void getWinnerRecords() {
        Car winner1 = mock(Car.class);
        Car winner2 = mock(Car.class);
        Car loser = mock(Car.class);
        when(winner1.getPosition()).thenReturn(2);
        when(winner2.getPosition()).thenReturn(2);
        when(loser.getPosition()).thenReturn(0);
        when(winner1.isAt(2)).thenReturn(true);
        when(winner2.isAt(2)).thenReturn(true);
        when(loser.isAt(2)).thenReturn(false);
        when(winner1.getRecord()).thenReturn(new RecordDto("winner1", 2));
        when(winner2.getRecord()).thenReturn(new RecordDto("winner2", 2));
        when(loser.getRecord()).thenReturn(new RecordDto("loser", 0));

        Cars cars = Cars.of(Arrays.asList(winner1, winner2, loser));

        List<RecordDto> winnerRecords = cars.getWinnerRecord();

        assertThat(winnerRecords).containsOnly(new RecordDto("winner1", 2),
                new RecordDto("winner2", 2));
    }
}