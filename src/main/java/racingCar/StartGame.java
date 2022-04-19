package racingCar;

import java.util.List;

public class StartGame {
    public static final int MOVE_CRITERIA = 4;
    public static final int ROUNDUP_NUMBER = 10;

    public void racingCarGame(int carNumber, int tryCount, List<String> cars){
        while(tryCount>0){
            for (int i =0; i < carNumber; i++) {
                moveCar(randomNumber(),cars, i);
                ResultView.result(cars, i);
            }
            System.out.println("");
            tryCount--;
        }
    }

    public int randomNumber(){
        return (int) (Math.random()*ROUNDUP_NUMBER);
    }

    public void moveCar(int number, List<String> cars, int index){
        if (number >= MOVE_CRITERIA){
            cars.set(index, cars.get(index)+"-");
        }
    }
}
