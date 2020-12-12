package racing.domain;

import racing.view.ViewResult;

public class GameRunner {
    private Cars cars;
    private int requestMoveCount;

    public GameRunner(Cars cars, int requestMoveCount) {
        this.cars = cars;
        this.requestMoveCount = requestMoveCount;
    }

    public Cars play() {
        ViewResult viewResult = new ViewResult();
        viewResult.showFirstLine();
        for(int i = 0; i < requestMoveCount; i++) {
            cars.run();
            viewResult.view(cars);
        }
        Cars winnerCars = cars.findWinner();
        viewResult.showWinnerCars(winnerCars);
        return cars;
    }
}
