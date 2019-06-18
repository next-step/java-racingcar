package step2;

import java.util.List;

public class OutputView {

    static void racingResult(List<Car> carList) {
        int carNumber = carList.size();
        for (int i = 0; i < carNumber; i++) {
            carResult(carList.get(i).lastCarPosition());
        }
        System.out.println();
    }

    static void carResult(int carMoveStatusNumber) {
        StringBuffer carMoveBuffer = new StringBuffer();
        while (carMoveStatusNumber > 0) {
            carMoveBuffer.append("-");
            carMoveStatusNumber--;
        }
        System.out.println(carMoveBuffer);
    }

}