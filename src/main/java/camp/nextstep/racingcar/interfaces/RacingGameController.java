package camp.nextstep.racingcar.interfaces;

import camp.nextstep.racingcar.domain.CarFactory;
import camp.nextstep.racingcar.domain.Cars;
import camp.nextstep.racingcar.domain.MoveCondition;
import camp.nextstep.racingcar.domain.PositiveNumber;
import camp.nextstep.racingcar.domain.RaceRecord;
import camp.nextstep.racingcar.domain.DefaultMoveCondition;
import camp.nextstep.racingcar.domain.RandomNumberGenerator;
import camp.nextstep.racingcar.view.InputView;
import camp.nextstep.racingcar.view.ResultView;
import java.util.ArrayList;
import java.util.List;

public class RacingGameController {

  public void race() {
    Cars cars = new Cars(CarFactory.of(InputView.getCarNames()));
    PositiveNumber rounds = new PositiveNumber(InputView.getRounds());
    MoveCondition moveCondition = new DefaultMoveCondition(new RandomNumberGenerator());

    List<RaceRecord> raceRecords = new ArrayList<>();
    for (int round = 1; round <= rounds.getNumber(); round++) {
      raceRecords.add(new RaceRecord(round, cars.race(moveCondition)));
    }
    ResultView.print(raceRecords);
  }

}
