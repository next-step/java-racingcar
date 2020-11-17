package racingcar;

import java.util.List;

public class ResultView {

    public void racingResult(List<Integer> list){

        for(int i = 0; i < list.size(); i++){
            for(int j = 0; j < list.get(i); j++){
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }
    
}