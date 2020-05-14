package com.nextstep.racingcar.application;

import com.nextstep.racingcar.domain.car.MoveLength;
import com.nextstep.racingcar.domain.round.RoundResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameResultTests {
    List<RoundResult> roundResults = new ArrayList<>();

    @BeforeEach
    public void setup() {
        roundResults.add(RoundResult.create("poppo", MoveLength.createZero()));
        roundResults.add(RoundResult.create("ita", MoveLength.createZero()));
    }

    @DisplayName("RoundResult 리스트를 입력받아서 객체를 생성할 수 있음")
    @Test
    void creatTest() {
        assertThat(RacingGameResult.create(roundResults)).isNotNull();
    }

    @DisplayName("사이드 이펙트가 없어야 함")
    @Test
    void sideEffectTest() {
        int resultSize = RacingGameResult.create(roundResults).size();
        assertThat(resultSize).isEqualTo(2);

        roundResults.add(RoundResult.create("poppo2", MoveLength.createZero()));

        assertThat(resultSize).isNotEqualTo(3);
    }
}
