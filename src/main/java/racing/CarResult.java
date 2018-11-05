package racing;

import java.util.List;

public class CarResult {

    public static void getRaceWinners(RacingGame racingGame) {
        int max = 0;
        String result = "";
        List<Car> cars = racingGame.getCars();

        for(Car car : cars){
            max = car.getMaxPosition(max);
        }
        for(Car car : cars){
            result += car.getWinner(max);
        }

        result = result.substring(0, result.length() -1 );
        result += "가 최종 우승했습니다.";
        System.out.println(result);
    }
}
