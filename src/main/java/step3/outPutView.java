package step3;

import com.sun.tools.javac.util.StringUtils;

import java.util.ArrayList;
import java.util.Collections;

public class outPutView {
    private static String MARK = "-";
    public void resultPrint(ArrayList<Integer> cars){
        for (Integer position : cars){
            drawRepeat(position);
        }
    }

    private void drawRepeat(int times){
        String join = String.join("", Collections.nCopies(times, MARK));
        System.out.println(join);
    }
}
