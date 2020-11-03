package step3.view;

import step3.RaceGameContract;
import step3.model.RaceGame;
import step3.model.RacingCars;

public class RenderingView implements RaceGameContract.View {

    private int executeCount;


    public RenderingView() {
        System.out.println("실행결과");
    }

    @Override
    public void renderView(RacingCars racingCars) {

        executeCount++;
    }


    public int getExecuteCount() {
        return executeCount;
    }
}
