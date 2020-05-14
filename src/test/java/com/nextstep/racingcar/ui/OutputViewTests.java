package com.nextstep.racingcar.ui;

import com.nextstep.racingcar.application.RacingGameResult;
import com.nextstep.racingcar.domain.car.MoveLength;
import com.nextstep.racingcar.domain.round.CarRoundResult;
import com.nextstep.racingcar.domain.round.RoundResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTests {
    private RacingGameResult racingGameResult;
    private List<RoundResult> roundResultList = new ArrayList<>();
    private List<CarRoundResult> carRoundOneResultList = new ArrayList<>();
    private List<CarRoundResult> carRoundTwoResultList = new ArrayList<>();
    private CarRoundResult poppoRoundOneResult;
    private CarRoundResult itaRoundOneResult;
    private CarRoundResult saulRoundOneResult;
    private CarRoundResult poppoRoundTwoResult;
    private CarRoundResult itaRoundTwoResult;
    private CarRoundResult saulRoundTwoResult;

    @BeforeEach
    public void setup() {
        poppoRoundOneResult = CarRoundResult.create("poppo", MoveLength.createByValue(1));
        itaRoundOneResult = CarRoundResult.create("ita", MoveLength.createByValue(1));
        saulRoundOneResult = CarRoundResult.create("saul", MoveLength.createByValue(1));
        poppoRoundTwoResult = CarRoundResult.create("poppo", MoveLength.createByValue(2));
        itaRoundTwoResult = CarRoundResult.create("ita", MoveLength.createByValue(1));
        saulRoundTwoResult = CarRoundResult.create("saul", MoveLength.createByValue(2));

        carRoundOneResultList.add(poppoRoundOneResult);
        carRoundOneResultList.add(itaRoundOneResult);
        carRoundOneResultList.add(saulRoundOneResult);

        carRoundTwoResultList.add(poppoRoundTwoResult);
        carRoundTwoResultList.add(itaRoundTwoResult);
        carRoundTwoResultList.add(saulRoundTwoResult);

        roundResultList.add(RoundResult.create(carRoundOneResultList));
        roundResultList.add(RoundResult.create(carRoundTwoResultList));

        racingGameResult = RacingGameResult.create(roundResultList);
    }

    @DisplayName("우승자를 제외하고 결과를 제대로 보여주는지 확인")
    @Test
    void printResultWithoutWinnerTest() {
        OutputView outputView = new OutputView(racingGameResult);
        String stringResult = outputView.toStringResult();
        assertThat(stringResult).isEqualTo("poppo : -\n" +
                "ita : -\n" +
                "saul : -\n" +
                "\n" +
                "poppo : --\n" +
                "ita : -\n" +
                "saul : --\n\n");
    }
}
