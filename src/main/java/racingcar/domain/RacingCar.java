package racingcar.domain;

class RacingCar {

    private int mileage;

    public RacingCar() {
        this.mileage = 0;
    }

    public void race(MotorRacingRule motorRacingRule){
        if(motorRacingRule.pass()) {
            mileage++;
        }
    }

    public int getMileage() {
        return mileage;
    }

    public static RacingCar attend(){
        return new RacingCar();
    }
}
