package racingcar.domain.core;

import racingcar.domain.rule.MotorRacingRule;
import racingcar.domain.RacingResult;

public interface RacingCar {
    static RacingCar attend(){
        return new IncreaseMileageRacingCar();
    }
    static RacingCar attend(String name){
        return new NamedRacingCar(name);
    }

    void racing(MotorRacingRule motorRacingRule);

    RacingResult getResult();
}
