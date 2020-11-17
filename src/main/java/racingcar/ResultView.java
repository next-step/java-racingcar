package racingcar;

import java.util.List;

public class ResultView {

    public void racingResult(List<Integer> list){

        for(int i = 0; i < list.size(); i++){
            printMove(list.get(i));
            System.out.println();
        }
        System.out.println();
    }

    public void printMove(int move){
        for(int j = 0; j < move; j++){
            System.out.print("-");
        }
    }
    
}