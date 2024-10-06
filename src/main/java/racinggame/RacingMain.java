package racinggame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import racinggame.random.DefaultRandomNumberGenerator;
import racinggame.view.OutPutView;
import racinggame.domain.RacingGame;
import racinggame.domain.SnapShotStore.SnapShot;
import racinggame.dto.InputDto;
import racinggame.view.InputView;

public class RacingMain {

    public static void main(String[] args) {
        InputDto read = InputView.readCount();
        RacingGame racingGame = new RacingGame(read.getCarCount(),read.getRepeatCount());
        SnapShot snapShot = racingGame.start(new DefaultRandomNumberGenerator());
        OutPutView.render(snapShot);
    }

//    private static List<List<Integer>> radoms(int repeatCount, int carCount) {
//        List<List<Integer>> radoms = new ArrayList<>();
//        for (int count = 0; count < repeatCount; count++) {
//            radoms.add(carCapacity(carCount));
//        }
//        return radoms;
//    }
//
//    private static List<Integer> carCapacity(int carCount) {
//        Random random = new Random();
//        List<Integer> result = new ArrayList<>();
//        for (int count = 0; count < carCount; count++) {
//            result.add(random.nextInt(10));
//        }
//        return result;
//    }
}
