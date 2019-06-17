package step2;

import java.util.List;

public class OutputView {

    static void racingResult(List<CarDto> carsPosition) {
        int carNumber = carsPosition.size();
        for (int i = 0; i < carNumber; i++) {
            carResult(carsPosition.get(i).getPosition());
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