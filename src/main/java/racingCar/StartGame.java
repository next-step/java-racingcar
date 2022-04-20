package racingCar;

import java.util.List;

public class StartGame {
    public static final int MOVE_CRITERIA = 4;
    public static final int ROUNDUP_NUMBER = 10;

    public void racingCarGame(int countOfCar, int tryCount, List<Car> cars){
        while(tryCount>0){
            moveCars(countOfCar, cars);
            tryCount--;
        }
    }

    public int randomNumber(){
        return (int) (Math.random()*ROUNDUP_NUMBER);
    }

    public void moveCar(int number, Car car){
        if (number >= MOVE_CRITERIA){
            car.setMove(car.getMove()+"-");
        }
    }

    public void moveCars(int countOfCar,List<Car> cars){
        for (int i=0; i<countOfCar; i++) {
            moveCar(randomNumber(),cars.get(i));
            ResultView.result(cars.get(i));
        }
        System.out.println("");
    }
}
