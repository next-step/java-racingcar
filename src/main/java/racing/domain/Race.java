package racing.domain;

import racing.view.ResultView;

public class Race {
    private Cars cars;
    private int numberOfLaps;


    public Race(Cars cars, int numberOfLaps) {
        this.cars = cars;
        this.numberOfLaps = numberOfLaps;
    }

    public boolean isSameLaps(int other) {
        return this.numberOfLaps == other;
    }

    public Cars startRacingAndReturnWinner() {
        ResultView.displayRaceStart();

        performLapAndDisplay();

        ResultView.displayRaceFinish();

        return cars.winners();
    }


    private void performLapAndDisplay() {
        System.out.println("실행 결과");
        ResultView.displayCar(this.cars);

        for(int i = 0; i < this.numberOfLaps - 1; i++) {
            cars.move();
            ResultView.displayCar(this.cars);
        }
    }


}
