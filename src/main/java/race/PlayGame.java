package race;

import race.util.RandomNumberGenerator;
import race.vehicle.Car;
import race.view.ResultView;

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
