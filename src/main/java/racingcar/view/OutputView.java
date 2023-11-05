package racingcar.view;

import java.util.List;

public class OutputView {

    public void print(List<String> items) {
        for (String item : items) {
            System.out.println(item);
        }
        System.out.println();
    }
}
