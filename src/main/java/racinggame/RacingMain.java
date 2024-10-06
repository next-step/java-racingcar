package racinggame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import racinggame.SnapShotStore.SnapShot;

public class RacingMain {

    public static void main(String[] args) {
        InputDto read = InputView.read();
        List<List<Integer>> radoms=new ArrayList<>();
        for(int count=0;count< read.getRepeatCount();count++){
            radoms.add(carCapercity(read.getCarCount()));
        }
        RacingGame racingGame = new RacingGame(read.getCarCount());
        racingGame.start(radoms);
        SnapShot snapShot = racingGame.matchResult();
        OutPutView.render(snapShot);
    }

    private static List<Integer> carCapercity(int carCount) {
        Random random = new Random();
        List<Integer> result = new ArrayList<>();
        for(int count=0;count< carCount;count++){
            result.add(random.nextInt(10));
        }
        return result;
    }
}
