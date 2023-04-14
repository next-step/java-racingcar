package racingcar.domain;

public class RacingCars {
    private RacingCar[] racingCars;

    public RacingCars(int numberOfCars) {
        this.racingCars = new RacingCar[numberOfCars];

        for(int i=0; i<numberOfCars; i++) {
            this.racingCars[i] = new RacingCar();
        }
    }

    // 자동차들 객체 가져오기
    public RacingCar[] getRacingCars() {
        return racingCars;
    }

    // carNumber로 특정 자동차 객체 가져오기
    public RacingCar getRacingCar(int carNumber) {
        return racingCars[carNumber];
    }
}
