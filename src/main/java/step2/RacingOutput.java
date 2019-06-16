package step2;

import java.util.List;

public class RacingOutput {

    public void racingResult(List<Integer> carsPosition) {
        int carNumber = carsPosition.size();
        for (int i = 0; i < carNumber; i++) {
            carResult(carsPosition.get(i));
        }
        System.out.println();
    }

    public void carResult(int carMoveStatusNumber) {
        StringBuffer carMoveBuffer = new StringBuffer();
        while (carMoveStatusNumber > 0) {
            carMoveBuffer.append("-");
            carMoveStatusNumber--;
        }
        System.out.println(carMoveBuffer);
    }

}