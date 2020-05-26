package step3;

import java.util.List;

public class ResultView {

    public ResultView() {
        System.out.println();
        System.out.println("실행결과");
    }

    public void showResult(List<Car> carList) {
        for (int i = 0; i < carList.size(); i++) {
            printPosition(carList.get(i).getCurrentPosition());
        }
        System.out.println();
    }

    private void printPosition(int positions) {
        for (int i = 0; i <= positions; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
