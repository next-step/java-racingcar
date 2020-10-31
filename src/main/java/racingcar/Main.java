/**
 * 클래스 이름: Main
 * 버전 정보: 0.1
 * 날짜: 2020.10.30
 * 저작권 주의: 없음
 */

package racingcar;

public class Main {
    public static void main(String[] args) {

        InputView inputView = InputView.getInstance();
        int carNum = inputView.askCarNum();
        int tryNum = inputView.askTryNum();
        inputView.printResultMsg();

        MoveStrategy strategy = new RandomMoveStrategy();
        Car[] carArr = new Car[carNum];
        for (int i = 0; i < carNum; i++) {
            carArr[i] = new Car(strategy);
        }
        RacingGame game = new RacingGame(carArr, tryNum);
        View view = new View(game);

        while (game.checkNotGameOver()) {
            System.out.println(view);
            game.play();
        }
    }
}
