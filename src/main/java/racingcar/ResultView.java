package racingcar;

import java.util.List;

public class ResultView {
    public void result(RacingGame racingGame) {
        System.out.println("실행결과");
        List<Car> carList = racingGame.getCarList();
        for (int i = 0; i <racingGame.getAttempts() ; i++) {
            for (int j = 0; j <carList.size() ; j++) {
                Car car = carList.get(j);
                boolean[] moves = car.getMoves();
                for (int k = 0; k <= i ; k++) {
                    if (moves[k]) {
                        System.out.print("-");
                    }
                }
                System.out.print("\n");
            }
            System.out.print("\n");
        }
    }
}
