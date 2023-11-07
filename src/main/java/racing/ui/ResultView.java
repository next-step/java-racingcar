package racing.ui;

import java.util.List;

public class ResultView {

    static String DISPLAY_TEST = "-";

    public static void viewResultView(List<Integer> resultList) {

        for(int number : resultList){
            System.out.println(intFormatString(number));
        }
        System.out.println();
    }

    private static String intFormatString(int count){
        return DISPLAY_TEST.repeat(count);
    }
}
