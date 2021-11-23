package com.sryoondev.racingcar.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;


class RecordsTest {
    @Test
    @DisplayName("우승자를 가져오는 메소드 테스트")
    void testFindWinners() {
        Record pobi = new Record("pobi", 3);
        Record hailey = new Record("hailey", 5);
        Record tony = new Record("tony", 5);

        Records records = new Records(Arrays.asList(pobi, hailey, tony));
        assertThat(records.findWinners()).contains(hailey, tony);
    }

    @Test
    @DisplayName("더 좋은 기록을 가져오는 메소드 테스트")
    public void testGetWinner() {
        Record pobi = new Record("pobi", 3);
        Record hailey = new Record("hailey", 5);
        assertThat(pobi.getWinner(hailey)).isEqualTo(hailey);
    }
}