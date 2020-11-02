package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
        int stepCount = 3;
        when(car1.getRecordCount()).thenReturn(stepCount);
        for (int step = 0; step < stepCount; step++) {
            when(car1.getRecordAtStep(step)).thenReturn(step + 1);
            when(car2.getRecordAtStep(step)).thenReturn(step);
        }
        Cars cars = Cars.of(Arrays.asList(car1, car2));

        List<List<Integer>> records = cars.getRecords();

        assertThat(records).contains(Arrays.asList(1, 0), Arrays.asList(2, 1), Arrays.asList(3, 2));
    }

    @DisplayName("자동차가 하나도 없을 때 기록")
    @Test
    public void getRecordsWithEmptyCars() {
        Cars cars = Cars.of(new ArrayList<>());

        assertThatThrownBy(cars::getRecords)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("no car");
    }
}