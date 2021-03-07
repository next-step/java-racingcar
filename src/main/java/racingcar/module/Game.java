package racingcar.module;

import racingcar.model.Car;
import racingcar.view.ResultView;

import java.util.List;
import java.util.Random;

public class Game {
    private final ResultView resultView;

    public Game() {
        this.resultView = new ResultView();
    }

    public int playCarGame(List<Car> carList, int tryNum){

        for(Car car : carList ) {
            if (randomNum() > 4) {
                car.move();
            }
            resultView.printCarGame(car.getCarNum(), car.getPosition());
        }
        System.out.println("");

        tryNum--;

        if(tryNum == 0){
            return 0;
        }

        return playCarGame(carList, tryNum);
    }

    public static int randomNum(){
        return new Random().nextInt(10);
    }


}
