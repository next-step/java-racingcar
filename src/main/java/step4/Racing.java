package step4;

public class Racing {

    public static void racing(Cars cars, int times) {
        for (int i = 0 ; i < times ; i++) {
            OutputRacingCar.printRound(racingRound(cars));
        }
    }

    public static Cars racingRound(Cars cars) {
        for (int i = 0; i < cars.getCarsSize() ; i++) {
            Car car = cars.getCar(i);
            car.moveOrStop(rule());
        }
        return cars;
    }

    public static MoveRule rule() {
        return new RandomMoveRule();
    }
}
