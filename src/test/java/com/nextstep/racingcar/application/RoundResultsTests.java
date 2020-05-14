package com.nextstep.racingcar.application;

import com.nextstep.racingcar.domain.car.MoveLength;
import com.nextstep.racingcar.domain.round.RoundResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RoundResultsTests {
    @DisplayName("RoundResult 리스트로 일급 콜렉션 생성 가능")
    @Test
    void createTest() {
        List<RoundResult> roundResultList = Arrays.asList(
                RoundResult.create("poppo", MoveLength.createZero()),
                RoundResult.create("ita", MoveLength.createZero())
        );
        assertThat(RoundResults.create(roundResultList)).isNotNull();
    }

    @DisplayName("사이드 이펙트가 없어야 한다.")
    @Test
    void sideEffectTest() {
        List<RoundResult> roundResultList = new ArrayList<>();
        roundResultList.add(RoundResult.create("poppo", MoveLength.createZero()));
        roundResultList.add(RoundResult.create("ita", MoveLength.createZero()));
        RoundResults roundResults = RoundResults.create(roundResultList);
        assertThat(roundResults.size()).isEqualTo(2);

        roundResultList.add(RoundResult.create("hi", MoveLength.createZero()));
        assertThat(roundResults.size()).isEqualTo(2);
    }

    @DisplayName("getter에도 사이드 이펙트가 없어야 한다.")
    @Test
    void sideEffectTestInGetter() {
        List<RoundResult> roundResultList = new ArrayList<>();
        roundResultList.add(RoundResult.create("poppo", MoveLength.createZero()));
        roundResultList.add(RoundResult.create("ita", MoveLength.createZero()));
        RoundResults roundResults = RoundResults.create(roundResultList);
        assertThat(roundResults.size()).isEqualTo(2);

        List<RoundResult> values = roundResults.getValues();
        assertThatThrownBy(() -> values.add(RoundResult.create("ita", MoveLength.createZero())))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}
