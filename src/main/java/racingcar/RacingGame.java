package racingcar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingGame {
    ResultView resultView = new ResultView();

    // Map<Integer, Integer> joinCar = new HashMap<>();
    List<Car> carList = new ArrayList<>();
    int move = 0;

    public void playRacing(List<Integer> input){
        sortForRacing(input);
        System.out.println("실행 결과");
        moveCar();
    }

    public void sortForRacing(List<Integer> input){
        for(int i = 0; i < input.get(0); i++){
            Car car = new Car(i);
            carList.add(car);
        }
        move = input.get(1);
    }

    public void moveCar(){
        for(int j = 0; j < move; j++){
            tryToMoveResult();
            resultView.racingResult(carList);
        }
    }

    public void tryToMoveResult(){
        for(int k = 0; k < carList.size(); k++){
            if(tryToMove() == true){
                Car car = carList.get(k);
                car.moveLocation(k);
                carList.set(k, car);
            }
        }
    }

    public boolean tryToMove(){
        boolean result = false;
        int random = (int)(Math.random()*9);

        if(random >=4){
            result = true;
        }

        return result;
    }

}