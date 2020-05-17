package com.nextstep.racingcar.application;

import com.nextstep.racingcar.domain.car.MoveLength;
import com.nextstep.racingcar.domain.round.CarRoundResult;
import com.nextstep.racingcar.domain.round.RoundResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameResultTests {
    List<CarRoundResult> carRoundResults = new ArrayList<>();
    List<RoundResult> roundResults = new ArrayList<>();

    @BeforeEach
    public void setup() {
        carRoundResults.add(CarRoundResult.create("poppo", MoveLength.createZero()));
        roundResults.add(RoundResult.create(carRoundResults));
    }

    @DisplayName("RoundResult 리스트를 입력받아서 객체를 생성할 수 있음")
    @Test
    void creatTest() {
        assertThat(RacingGameResult.create(roundResults)).isNotNull();
    }

    @DisplayName("사이드 이펙트가 없어야 함")
    @Test
    void sideEffectTest() {
        RacingGameResult racingGameResult = RacingGameResult.create(roundResults);
        assertThat(racingGameResult.size()).isEqualTo(1);

        roundResults.add(RoundResult.create(carRoundResults));

        assertThat(racingGameResult.size()).isEqualTo(1);
    }
}
