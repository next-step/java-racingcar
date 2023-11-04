package step3.view;

import java.util.List;

public class OutputView {

    public void print(List<Object> items) {
        for (Object item : items) {
            System.out.println(item.toString());
        }
        System.out.println();
    }
}
