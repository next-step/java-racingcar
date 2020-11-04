package step3.view;

import step3.RaceGameContract;
import step3.model.RacingCars;

import java.util.Collections;
import java.util.stream.IntStream;

public class RenderingView implements RaceGameContract.View {

    private int executeCount;


    public RenderingView() {
        System.out.println("실행결과");
    }

    @Override
    public void renderView(RacingCars racingCars) {
        for (int i = 0; i < racingCars.getTotalRound(); i++) {
            racingCars.roundResult();
        }
        executeCount++;
    }

    private void getRoundResult(RacingCars racingCars) {

    }

    public int getExecuteCount() {
        return executeCount;
    }
}
