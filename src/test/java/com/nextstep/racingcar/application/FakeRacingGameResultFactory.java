package com.nextstep.racingcar.application;

import com.nextstep.racingcar.domain.car.MoveLength;
import com.nextstep.racingcar.domain.round.CarRoundResult;
import com.nextstep.racingcar.domain.round.RoundResult;

import java.util.ArrayList;
import java.util.List;

public class FakeRacingGameResultFactory {
    public static RacingGameResult getFakeRacingGameResult() {
        List<RoundResult> roundResultList = new ArrayList<>();
        List<CarRoundResult> carRoundOneResultList = new ArrayList<>();
        List<CarRoundResult> carRoundTwoResultList = new ArrayList<>();
        CarRoundResult poppoRoundOneResult;
        CarRoundResult itaRoundOneResult;
        CarRoundResult saulRoundOneResult;
        CarRoundResult poppoRoundTwoResult;
        CarRoundResult itaRoundTwoResult;
        CarRoundResult saulRoundTwoResult;

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

        return RacingGameResult.create(roundResultList);
    }
}
