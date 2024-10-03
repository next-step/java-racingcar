package step4;

import step4.util.RandomNumberGenerator;
import step4.vehicle.Car;
import step4.vehicle.Cars;
import step4.view.ResultView;

public class PlayGame {
    Cars cars;
    ResultView resultView;
    PlayGame(Cars cars, ResultView resultView) {
        this.cars = cars;
        this.resultView = resultView;
    }

    public void gameStart(int round){
        resultView.printResultView();
        for(int i = 0; i< round; i++){
            for(Car car : cars.getCars()){
                resultView.printCarName(car);
                resultView.printCarLocation(car.getLocation());
                car.move(RandomNumberGenerator.getRandomGenerator());
            }
            resultView.separateRound();
        }
        resultView.printWinners(cars.getWinners());
    }

}
