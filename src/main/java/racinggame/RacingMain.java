package racinggame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import racinggame.SnapShotStore.SnapShot;

public class RacingMain {

    public static void main(String[] args) {
        InputDto read = InputView.readCount();
        RacingGame racingGame = new RacingGame(read.getCarCount());
        racingGame.start(radoms(read.getRepeatCount(),read.getCarCount()));
        SnapShot snapShot = racingGame.matchResult();
        OutPutView.render(snapShot);
    }

    private static List<List<Integer>> radoms(int repeatCount,int carCount) {
        List<List<Integer>> radoms=new ArrayList<>();
        for(int count=0;count< repeatCount;count++){
            radoms.add(carCapacity(carCount));
        }
        return radoms;
    }

    private static List<Integer> carCapacity(int carCount) {
        Random random = new Random();
        List<Integer> result = new ArrayList<>();
        for(int count=0;count< carCount;count++){
            result.add(random.nextInt(10));
        }
        return result;
    }
}
