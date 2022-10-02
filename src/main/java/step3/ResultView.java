package step3;

import java.util.Scanner;

public class ResultView {

    public ResultView() {
    }

    public void startView() {
        System.out.println("실행 결과");
    }

    public void resultView(Car car) {
        for(int i = 0; i < car.currentLocation(); i++) {
            System.out.print("-");
        }
        System.out.println("\n");
    }
}
