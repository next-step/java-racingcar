package step3;

import java.util.Collections;
import java.util.List;

public class OutputView {

    private static String MARK = "-";

    public void resultPrint(List<Integer> positionList){
        for (Integer position : positionList){
            drawRepeat(position);
        }
    }

    private void drawRepeat(int times){
        String markFullString = String.join("", Collections.nCopies(times, MARK));
        System.out.println(markFullString);
    }
}
