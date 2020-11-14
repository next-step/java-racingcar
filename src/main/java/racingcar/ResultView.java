package racingcar;

import java.util.Map;

public class ResultView {

    public void racingResult(Map<Integer, Integer> joinCar){
        for(int i = 0; i < joinCar.size(); i++){
            int result = joinCar.get(i);
            for(int j = 0; j < result; j++){
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }
    
}