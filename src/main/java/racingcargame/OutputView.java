package racingcargame;

import java.util.List;

public class OutputView {

    public void output(List<Car> racingOutput) {
        for (int i = 0; i < racingOutput.size(); i++) {
            System.out.println(racingOutput.get(i).getLocation());
        }
        System.out.println();
    }
}
