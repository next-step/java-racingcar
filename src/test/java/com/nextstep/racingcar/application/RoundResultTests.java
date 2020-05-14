package com.nextstep.racingcar.application;

import com.nextstep.racingcar.domain.car.MoveLength;
import com.nextstep.racingcar.domain.round.CarRoundResult;
import com.nextstep.racingcar.domain.round.RoundResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RoundResultTests {
    @DisplayName("RoundResult 리스트로 일급 콜렉션 생성 가능")
    @Test
    void createTest() {
        List<CarRoundResult> carRoundResultList = Arrays.asList(
                CarRoundResult.create("poppo", MoveLength.createZero()),
                CarRoundResult.create("ita", MoveLength.createZero())
        );
        assertThat(RoundResult.create(carRoundResultList)).isNotNull();
    }

    @DisplayName("사이드 이펙트가 없어야 한다.")
    @Test
    void sideEffectTest() {
        List<CarRoundResult> carRoundResultList = new ArrayList<>();
        carRoundResultList.add(CarRoundResult.create("poppo", MoveLength.createZero()));
        carRoundResultList.add(CarRoundResult.create("ita", MoveLength.createZero()));
        RoundResult roundResult = RoundResult.create(carRoundResultList);
        assertThat(roundResult.size()).isEqualTo(2);

        carRoundResultList.add(CarRoundResult.create("hi", MoveLength.createZero()));
        assertThat(roundResult.size()).isEqualTo(2);
    }

    @DisplayName("getter에도 사이드 이펙트가 없어야 한다.")
    @Test
    void sideEffectTestInGetter() {
        List<CarRoundResult> carRoundResultList = new ArrayList<>();
        carRoundResultList.add(CarRoundResult.create("poppo", MoveLength.createZero()));
        carRoundResultList.add(CarRoundResult.create("ita", MoveLength.createZero()));
        RoundResult roundResult = RoundResult.create(carRoundResultList);
        assertThat(roundResult.size()).isEqualTo(2);

        List<CarRoundResult> values = roundResult.getValues();
        assertThatThrownBy(() -> values.add(CarRoundResult.create("ita", MoveLength.createZero())))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @DisplayName("형식에 맞춰서 현재의 결과를 String으로 표현해야 한다.")
    @Test
    void toStringResult() {
        List<CarRoundResult> carRoundResultList = new ArrayList<>();
        carRoundResultList.add(CarRoundResult.create("poppo", MoveLength.createByValue(1)));
        carRoundResultList.add(CarRoundResult.create("ita", MoveLength.createByValue(2)));
        RoundResult roundResult = RoundResult.create(carRoundResultList);

        assertThat(roundResult.toStringResult()).isEqualTo("poppo : -\nita : --\n");
    }
}
