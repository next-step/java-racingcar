package racingcar.view;

import java.util.List;

public class OutputView {

    public void print(List<String> items) {
        for (String item : items) {
            print(item);
        }
        System.out.println();
    }

    public void print(String item) {
        System.out.println(item);
    }
}
