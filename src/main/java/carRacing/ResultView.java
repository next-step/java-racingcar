package carRacing;

import java.util.List;

public class ResultView {
    public static final String LINE = "-";

    public static void resultTitle(){
        System.out.println("실행 결과");
    }

    public static void printRoundResult(List<Integer> distanceList){
        for(int distance : distanceList){
            String line = LINE.repeat(distance);
            System.out.println(line);
        }
        System.out.println();
    }

}
