package com.nextstep.racingcar.application;

import com.nextstep.racingcar.domain.car.MoveLength;
import com.nextstep.racingcar.domain.round.RoundResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameResultTests {
    List<RoundResult> roundResults;

    @BeforeEach
    public void setup() {
        roundResults = Arrays.asList(
                RoundResult.create("poppo", MoveLength.createZero()),
                RoundResult.create("ita", MoveLength.createZero())
        );
    }

    @DisplayName("RoundResult 리스트를 입력받아서 객체를 생성할 수 있음")
    @Test
    void creatTest() {
        assertThat(RacingGameResult.create(roundResults)).isNotNull();
    }
}
