package step3;

import java.util.Collections;
import java.util.List;

public class OutputView {

    private static String MARK = "-";

    public void resultPrint(List<Car> cars){
        for (Car car : cars){
            drawRepeat(car.getPosition());
        }
    }

    private void drawRepeat(int times){
        String join = String.join("", Collections.nCopies(times, MARK));
        System.out.println(join);
    }
}
