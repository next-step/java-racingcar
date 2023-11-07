package racing;

import java.util.List;

public class ResultView {
    private final static String ICON = "-";
    public static void showResult(int count){
        System.out.println(ICON.repeat(count));
    }
}
