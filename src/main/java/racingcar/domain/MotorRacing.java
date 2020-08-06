package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import racingcar.domain.core.RacingCar;
import racingcar.domain.rule.MotorRacingRule;
import racingcar.ui.view.MotorRacingDisplayResults;
import racingcar.ui.view.MotorRacingDisplayRoundResult;

import static java.util.stream.Collectors.toList;

public class MotorRacing {
    private final List<RacingCar> racingCars;
    private final MotorRacingRule motorRacingRule;

    @Deprecated
    MotorRacing(int carCount, MotorRacingRule motorRacingRule) {
        this.racingCars = Stream.generate(RacingCar::attend)
            .limit(carCount)
            .collect(toList());
        this.motorRacingRule = motorRacingRule;
    }

    MotorRacing(Set<String> carNames, MotorRacingRule motorRacingRule) {
        this.racingCars = carNames.stream()
                                  .map(RacingCar::attend)
                                  .collect(toList())
        ;
        this.motorRacingRule = motorRacingRule;
    }

    @Deprecated
    public static MotorRacing randomMotorRacing(int carCount){
        return new MotorRacing(carCount,  MotorRacingRule.defaultMoveRule());
    }

    public static MotorRacing randomMotorRacing(Set<String> carNames){
        return new MotorRacing(carNames,  MotorRacingRule.defaultMoveRule());
    }

    public MotorRacingDisplayResults racing(final int raceRound){
        final MotorRacingDisplayResults motorRacingDisplayResults = new MotorRacingDisplayResults();
        for(int round = 0; raceRound > round; ++round) {
            motorRacingDisplayResults.saveEachRound(allCarsStartRacing());
        }
        return motorRacingDisplayResults;
    }

    private MotorRacingDisplayRoundResult allCarsStartRacing() {
        final List<RacingResult> collect = racingCars.stream()
                                          .peek(this::runMotorRace)
                                          .map(RacingCar::getResult)
                                          .collect(toList());
        return new MotorRacingDisplayRoundResult(Collections.unmodifiableList(collect));
    }
    private void runMotorRace(RacingCar car){
        car.racing(motorRacingRule);
    }
}
