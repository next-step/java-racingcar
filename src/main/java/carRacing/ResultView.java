package carRacing;

import java.util.List;

public class ResultView {


    public static void resultTitle(){
        System.out.println("실행 결과");
    }

    public static void printRoundResult(List<Integer> carList){

        for(int car : carList){
            String distance = "-".repeat(car);
            System.out.println(distance);
        }
        System.out.println();
    }
}
