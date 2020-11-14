package racingcar;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingGame {
    Map<Integer, Integer> joinCar = new HashMap<Integer, Integer>();
    int move = 0;

    public void playRacing(List<Integer> input){
        sortForRacing(input);

    }

    public void sortForRacing(List<Integer> input){
        for(int i = 0; i <= input.get(0); i++){
            joinCar.put(i, 0);
        }
        move = input.get(1);
    }

    public void carMove(){

    }

}