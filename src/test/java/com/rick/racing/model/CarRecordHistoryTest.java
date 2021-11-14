package com.rick.racing.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.IntStream;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarRecordHistoryTest {

    final private CarRecordHistory carRecordHistory = new CarRecordHistory();

    @Test
    @DisplayName("Go, Stop 에 따른 이동 기록 확인")
    void goAndStopHistory() {
        final List<Boolean> inputValues = Lists.list(true, true, false, false, true);
        final List<Integer> expectedValues = Lists.list(1, 2, 2, 2, 3);

        inputValues.forEach(this::move);
        IntStream.range(0, carRecordHistory.getSize())
            .forEach(index -> assertThat(carRecordHistory.isEqual(index, expectedValues.get(index))).isEqualTo(true));
    }

    private void move(Boolean goOrStop) {
        if (goOrStop) {
            carRecordHistory.go();
            return;
        }

        carRecordHistory.stop();
    }
}
