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

    public static void racingWinnerResult(List<Car> cars){
        RacingWinner racingWinner = new RacingWinner(cars);
        String winners = racingWinner.maxPostionCarName();
        System.out.println(winners + "가 최종 우승 했습니다.");
    }

}