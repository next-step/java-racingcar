package racingCar;

import java.util.List;

public class ResultView {

    public void createResultView(List<Integer[]> result) {
        for (Integer[] integers : result) {
            for (Integer integer : integers) {
                for (Integer i = 0; i < integer; i++) {
                    System.out.print('-');
                }
                System.out.println();
            }
            System.out.println();
            System.out.println();
        }
    }
}
