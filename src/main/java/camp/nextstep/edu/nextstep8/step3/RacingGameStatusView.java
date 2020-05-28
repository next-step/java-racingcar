package camp.nextstep.edu.nextstep8.step3;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class RacingGameStatusView {

    private AtomicInteger roundCount = new AtomicInteger(1);

    public void showPosition(RacingCar racingCar, boolean debug) {
        if(debug) {
            System.out.print("[" + racingCar.getNumber() + "] ");
            racingCar.getDebugPosition().forEach(n -> System.out.print(n + " "));
            System.out.println();
        }
        racingCar.getPosition().forEach(s -> System.out.print(s));
        System.out.println();
    }

    public void showRoundResult(List<RacingCar> participatedList, boolean debug) {
        System.out.println("ROUND : " + roundCount.getAndIncrement());
        participatedList.forEach(racingCar -> {
            showPosition(racingCar, debug);
        });
    }

    public void showRoundResult(List<RacingCar> participatedList){
        showRoundResult(participatedList, false);
    }
}
