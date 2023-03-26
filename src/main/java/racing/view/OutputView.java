package racing.view;

import racing.Car;
import racing.domain.GetWinner;
import racing.domain.Racing;

public class OutputView {

    private static void printCarPosition(Car[] cars) {
        for (Car car : cars) {
            System.out.println(car.getPositionFormat());
        }
    }

    public String winnerCar(int round, Car[] cars) {

        System.out.println("실행결과");
        int winnerPosition = Racing.racing(round, cars);

        String winner = GetWinner.getWinner(winnerPosition, cars);
        printCarPosition(cars); //CarPosion도 View모델로 분리
        return winner;
    }


}
