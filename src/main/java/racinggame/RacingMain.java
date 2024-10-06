package racinggame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import racinggame.view.OutPutView;
import racinggame.domain.RacingGame;
import racinggame.domain.SnapShotStore.SnapShot;
import racinggame.dto.InputDto;
import racinggame.view.InputView;

public class RacingMain {

    public static void main(String[] args) {
        InputDto read = InputView.readCount();
        RacingGame racingGame = new RacingGame(read.getCarCount());
        SnapShot snapShot = racingGame.start(radoms(read.getRepeatCount(), read.getCarCount()));
        OutPutView.render(snapShot);
    }

    private static List<List<Integer>> radoms(int repeatCount, int carCount) {
        List<List<Integer>> radoms = new ArrayList<>();
        for (int count = 0; count < repeatCount; count++) {
            radoms.add(carCapacity(carCount));
        }
        return radoms;
    }

    private static List<Integer> carCapacity(int carCount) {
        Random random = new Random();
        List<Integer> result = new ArrayList<>();
        for (int count = 0; count < carCount; count++) {
            result.add(random.nextInt(10));
        }
        return result;
    }
}
