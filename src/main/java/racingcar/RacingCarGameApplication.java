package racingcar;

import java.util.List;

public class RacingCarGameApplication {

    public static void main(String[] args) {
        Input input = new KeyboardInput(System.in);

        // TODO: carNames와 tryCount를 여기서 일일이 받지 말고,
        //  내부에서 처리하도록 하는 무언가가 있으면 좋겠다.
        //  + carNames별 length 체크까지 내부에서 다 하게끔
        List<String> carNames = input.getCarNames();
        int tryCount = input.getTryCount();

        // TODO: main에서 아예 MoveChecker를 모르게 하는게 좋을 것 같다.
        MoveChecker moveChecker = new MoveChecker();

        Game game = new Game(carNames, tryCount, moveChecker);
        game.start();
    }
}
