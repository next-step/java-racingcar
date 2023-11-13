package racing;

import java.util.List;
import javax.swing.plaf.LabelUI;

public class ResultView {

    private static final String OutputRacing = "-";
    public static void outputPrint(List<Car> carList) {

        for (Car car : carList) {
            System.out.println(OutputRacing.repeat(car.getDistance()));
        }
        System.out.println(" ");
    }


}
