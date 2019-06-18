package step2;

import java.util.List;

public class OutputView {

    static void racingResult(List<Car> carList) {
        carList.forEach((car) -> carResult(car.lastCarPosition()));
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