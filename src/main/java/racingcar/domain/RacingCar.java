package racingcar.domain;

interface RacingCar {
    static RacingCar attend(){
        return new IncreaseMileageRacingCar();
    }
    static RacingCar attend(String name){
        return new NamedRacingCar(name);
    }

    void racing(MotorRacingRule motorRacingRule);

    RacingResult getResult();
}
