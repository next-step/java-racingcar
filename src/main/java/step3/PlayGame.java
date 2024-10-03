package step3;

import step3.util.RandomNumberGenerator;
import step3.vehicle.Car;
import step3.view.ResultView;

import java.util.List;

public class PlayGame {
    List<Car> cars;
    ResultView resultView;
    PlayGame(List<Car> cars, ResultView resultView) {
        this.cars = cars;
        this.resultView = resultView;
    }

    public void gameStart(int round){
        resultView.printResultView();
        for(int i = 0; i< round; i++){
            for(Car car : cars){
                resultView.printCarLocation(car.getLocation());
                car.move(RandomNumberGenerator.getRandomGenerator());
            }
            resultView.separateRound();
        }
    }

}
