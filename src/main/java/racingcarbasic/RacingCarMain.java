package racingcarbasic;

public class RacingCarMain {

    public static void main(String[] args) {
        /* 자동차 대수와 움직일 횟수 받기 */
        InputView inputView = new InputView();
        int carNum = inputView.getCarNum();
        int moveCount = inputView.getMoveCount();

        System.out.println(carNum +" "+moveCount);
    }
}
