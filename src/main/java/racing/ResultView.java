package racing;

import java.util.List;

public class ResultView {

    public static void printResult(List<Car> cars) {
        for(Car car : cars) {
            for(int i = 0 ; i < car.getPosition() ; i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();

    }

}
