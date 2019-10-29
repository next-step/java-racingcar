package com.seok.racing.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RecordTest {

    private static final int FORWARD = 1;
    private static final int IN_PLACE = 0;

    @Test
    void getTotalDistance() {
        Record record = new Record();
        record.record(FORWARD);
        record.record(FORWARD);
        assertThat(record.getTotalDistance()).isEqualTo(2);
    }

    @Test
    void getCumulativeDistance() {
        Record record = new Record();
        record.record(FORWARD);
        record.record(FORWARD);
        record.record(IN_PLACE);
        record.record(FORWARD);

        assertThat(record.getCumulativeDistance(0)).isEqualTo(1);
        assertThat(record.getCumulativeDistance(1)).isEqualTo(2);
        assertThat(record.getCumulativeDistance(2)).isEqualTo(2);
        assertThat(record.getCumulativeDistance(3)).isEqualTo(3);


    }


}