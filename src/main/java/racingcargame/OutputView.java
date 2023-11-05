package racingcargame;

import java.util.Objects;

public class OutputView {

    public static String[] racingOutput;

    public void output() {
        for (int i = 0; i < racingOutput.length; i++) {
            if (Objects.isNull(racingOutput[i])) {
                System.out.println();
                continue;
            }
            System.out.println(racingOutput[i]);
        }
        System.out.println();
    }
}
