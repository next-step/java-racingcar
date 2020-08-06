package racingcar.domain.core;

import racingcar.domain.MotorRacingRule;
import racingcar.domain.RacingResult;

import static racingcar.domain.RacingResult.defaultResult;

class IncreaseMileageRacingCar implements RacingCar {

    private int mileage;

    public IncreaseMileageRacingCar() {
        this.mileage = 0;
    }

    @Override
    public void racing(MotorRacingRule motorRacingRule){
        if(motorRacingRule.pass()) {
            mileage++;
        }
    }

    int getMileage() {
        return mileage;
    }

    @Override
    public RacingResult getResult() {
        return defaultResult(getMileage());
    }
}
