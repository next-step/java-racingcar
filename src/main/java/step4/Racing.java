package step4;

public class Racing {

    public void racing (Cars cars, int times, OutputRacingCar outputResult) {
        for (int i = 0 ; i < times ; i++) {
            outputResult.printRound(racingRound(cars));
        }
    }

    public Cars racingRound(Cars cars) {
        for (int i = 0; i < cars.getCarsSize() ; i++) {
            Car car = cars.getCar(i);
            car.moveOrStop();
        }
        return cars;
    }


}
