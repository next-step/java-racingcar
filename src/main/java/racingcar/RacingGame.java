package racingcar;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingGame {
    ResultView resultView = new ResultView();

    Map<Integer, Integer> joinCar = new HashMap<>();
    int move = 0;

    public void playRacing(List<Integer> input){
        sortForRacing(input);
        System.out.println("실행 결과");
        moveCar();
    }

    public void sortForRacing(List<Integer> input){
        for(int i = 0; i < input.get(0); i++){
            joinCar.put(i, 1);
        }
        move = input.get(1);
    }

    public void moveCar(){
        for(int j = 0; j < move; j++){
            tryToMoveResult();
            resultView.racingResult(joinCar);
        }
    }

    public void tryToMoveResult(){
        for(int k = 0; k < joinCar.size(); k++){
            if(tryToMove() == true){
                joinCar.put(k, joinCar.get(k)+1);
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