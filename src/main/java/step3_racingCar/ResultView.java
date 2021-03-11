package step3_racingCar;

import java.util.LinkedList;

public class ResultView {
    public static void printResult(LinkedList<Integer> result){
        result.stream().forEach(integer -> {
            for(int i = 0; i<integer; i++){
                System.out.print("-");
            }
            System.out.println();
        });
    }
}
