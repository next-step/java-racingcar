package racingcarbasic;

public class RacingCarMain {

    public static void main(String[] args) {
        /* 자동차 대수와 이동 횟수 받기 */
        InputView inputView = new InputView();
        int carNum = inputView.getCarNum();
        int moveCount = inputView.getMoveCount();

        System.out.println(carNum + " " + moveCount);

        /* RacingCar 인스턴스 생성 */
        RacingCars racingCars = RacingCars.of(carNum, new StraightMove());

        ResultView resultView = new ResultView();
        for (int i = 0; i < moveCount; i++) {
            racingCars.moveCars();
            resultView.ResultPrint(racingCars);
        }

    }
}
