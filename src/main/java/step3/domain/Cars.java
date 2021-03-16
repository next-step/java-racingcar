package step3.domain;

import step3.exception.CarRaceCheckInputException;
import step3.util.RandomUtil;
import step3.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    List <Car> carList ;

    public Cars() {
        carList = new ArrayList<>();
    }

    public void createCarList(int carCount){
        if(carCount < 1){
            throw new CarRaceCheckInputException("자동차 수가 유효하지 않습니다. 입력값 : %d".replace("%d",Integer.toString(carCount)));
        }

        for(int i = 0; i< carCount ; i++){
            carList.add(new Car());
        }
    }

    public void playGame(int racingCount, ResultView resultView) {
        if(racingCount < 1){
            throw new CarRaceCheckInputException("시도할 회수가 유효하지 않습니다. 입력값 : %d".replace("%d",Integer.toString(racingCount)));
        }
        while(racingCount > 0){
            move();
            displayMove(resultView);
            racingCount--;
        }
    }

    private void move() {
        for(Car car : carList){
            car.go(RandomUtil.getRandomValue());
        }
    }

    private void displayMove(ResultView resultView) {
        resultView.displayMove(carList);
    }

    public List<Car> getCarList() {
        return carList;
    }

}
