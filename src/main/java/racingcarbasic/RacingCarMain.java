package racingcarbasic;

import java.util.Arrays;

public class RacingCarMain {

    public static void main(String[] args) {
        /* 자동차 대수와 이동 횟수 받기 */
        InputView inputView = new InputView();
        int carNum = inputView.getCarNum();
        int moveCount = inputView.getMoveCount();

        System.out.println(carNum + " " + moveCount);

        /* 이동 또는 멈춤 */
        int[] carMoveCount = new int[carNum];
        Arrays.fill(carMoveCount, 0);

        RacingCar racingCar = new RacingCar();
        ResultView resultView = new ResultView();
        for (int i = 0; i < moveCount; i++) {
            carMoveCount = racingCar.getMoveCount(carMoveCount);

            /* 실행 결과 출력 */
            resultView.ResultPrint(carMoveCount);
        }


    }
}
