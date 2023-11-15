package step4.racing;

import step4.racing.inout.OutPutView;

public class CarRacing {
    private final Cars cars;
    private final Referee referee;
    private final int howManyTimesToTry;

    private CarRacing(Cars cars, int howManyTimesToTry, Referee referee) {
        this.cars = cars;
        this.howManyTimesToTry = howManyTimesToTry;
        this.referee = referee;
    }

    public static CarRacing defaultOf(Cars cars, int howManyTimesToTry, Referee referee) {
        return new CarRacing(cars,howManyTimesToTry, referee);
    }

    public void start(OutPutView outPutView) {
        for (int i = 0; i < howManyTimesToTry; i++) {
            cars.move(referee);
            cars.printStatus(outPutView);
        }
        Winners winners = cars.voteWinner();
        winners.printWinners(outPutView);
    }
}
