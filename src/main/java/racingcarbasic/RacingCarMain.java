package racingcarbasic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class RacingCarMain {

    public static void main(String[] args) {
        /* 자동차 대수와 이동 횟수 받기 */
        InputView inputView = new InputView();
        int carNum = inputView.getCarNum();
        int moveCount = inputView.getMoveCount();

        System.out.println(carNum + " " + moveCount);

        /* RacingCar 인스턴스 생성 */
        ArrayList<RacingCar> carList = new ArrayList<>();
        for (int n=0; n<carNum; n++) {
            carList.add(new RacingCar("car" + n, 0));
        }

        ResultView resultView = new ResultView();
        for(int i=0; i<moveCount; i++) {
            for (RacingCar car : carList) {
                /* 0~9까지 랜덤값 생성 */
                Random random = new Random();
                int randomNum = random.nextInt(10);

                /* 이동 또는 멈춤 전략 */
                car.setMoveStrategy(new StraightMove());
                car.move(randomNum);
            }

            resultView.ResultPrint();
        }


    }
}
