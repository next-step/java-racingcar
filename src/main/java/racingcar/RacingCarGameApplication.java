package racingcar;

import java.util.List;

public class RacingCarGameApplication {

    public static void main(String[] args) {
        Input input = new KeyboardInput(System.in);

        // TODO: carNames와 rounds를 여기서 일일이 받지 말고,
        //  내부에서 처리하도록 하는 무언가가 있으면 좋겠다.
        //  + carNames별 length 체크까지 내부에서 다 하게끔
        List<String> carNames = input.getCarNames();
        int rounds = input.getRounds();

        RacingGame game = new RacingGame(carNames, rounds);
        game.play();
    }
}
