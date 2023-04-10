package racingcar;

public class ResultView {
    public static final String FOOTPRINT = "﹣";

    public static void printResult(int[] locationList){
        for(int loc:locationList){
            System.out.println(FOOTPRINT.repeat(loc));
        }
    }
}
