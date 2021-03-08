package racingcar.module;

import racingcar.model.Car;
import racingcar.util.RandomUtil;
import racingcar.view.ResultView;

import java.util.List;
import java.util.Random;

public class Game {
    private final ResultView resultView;
    private final List<Car> carList;

    public Game(List<Car> carList) {
        this.resultView = new ResultView();
        this.carList = carList;
    }

    public int startGame(int tryNum){
        playCarGame(carList);
        tryNum--;
        if(tryNum == 0) return 0;
        return startGame(tryNum);
    }

    public void playCarGame(List<Car> cars){
        for(Car car : cars ) {
            if (RandomUtil.randomNum() > 4) {
                car.move();
            }
            resultView.printCarGame(car.getCarNum(), car.getPosition());
        }
        System.out.println("");

    }


}
