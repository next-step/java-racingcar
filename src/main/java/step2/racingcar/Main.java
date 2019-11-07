/*
 * Description : 자동차경주 실행을 담당
 */

package step2.racingcar;

public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        RacingGame racingGame = new RacingGame();

        int[] carPositionArr = racingGame.markCarOnTrack(inputView.createCar());
        int maxLapCount = inputView.createRacingLap();

        racingGame.start(carPositionArr, maxLapCount);
    }
}
