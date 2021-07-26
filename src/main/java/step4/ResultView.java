package step4;

import step3.model.Car;

public class ResultView {
    public void showCurrCarPosition(int location) {
        for (int i = 0; i < location; i++) {
            System.out.print("-");
        }
        System.out.println();

    }
}
