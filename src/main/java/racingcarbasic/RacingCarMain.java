package racingcarbasic;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class RacingCarMain {

    public static void main(String[] args) {
        /* 자동차 대수와 이동 횟수 받기 */
        InputView inputView = new InputView();
        int carNum = inputView.getCarNum();
        int moveCount = inputView.getMoveCount();

        System.out.println(carNum + " " + moveCount);

        /* RacingCar 인스턴스 생성 */
        List<Car> carList = Stream.generate(() -> new Car("car", 0))
                .limit(carNum)
                .collect(Collectors.toList());

        /* 일급 컬렉션 선언*/
        RacingCars racingCars = new RacingCars(carList);

        ResultView resultView = new ResultView();
        for (int i = 0; i < moveCount; i++) {
            racingCars.moveCars(carList);
            resultView.ResultPrint(carList);
        }


    }
}
