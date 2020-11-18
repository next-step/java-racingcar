package step3;

import java.util.List;

public class ResultView {

    public void showResultMessage() {
        System.out.println();
        System.out.println(Constants.MSG_RESULT);
    }

    public void printRoundResult(List<Car> carList) {
        carList.forEach(item -> {
            printEachCar(item.position);
        });
        System.out.println();
    }

    public void printEachCar(int position) {
        for (int i = 0; i < position; i++) {
            System.out.print(Constants.MOVE_MARK);
        }
        System.out.println();
    }
}
