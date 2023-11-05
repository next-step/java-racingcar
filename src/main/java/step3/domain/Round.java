package step3.domain;


import step3.domain.Cars;
import step3.view.ResultView;

public class Round {

    private Cars cars;

    public Round(Cars cars) {
        this.cars = cars;
    }

    public void playRound(Cars cars) {
        cars.moveForwardCars();
    }

    public void printRoundResults() {
        ResultView resultView = new ResultView();
        cars.getCars().stream()
                .forEach(car -> resultView.printCurrentCarPosition(car));
        System.out.println();
    }
}
