package step3.view;

import step3.RaceGameContract;
import step3.model.RaceGame;
import sun.text.resources.CollationData;

import java.util.Collections;
import java.util.List;

public class RenderingView implements RaceGameContract.View {

    private int executeCount;


    public RenderingView() {
        System.out.println("실행결과");
    }

    @Override
    public void renderView(RaceGame raceGame) {
        List<Integer> result = raceGame.getMoveTracks();
        for (int i = 0; i < result.size(); i++) {
            System.out.println(String.join("", Collections.nCopies(result.get(i), "-")));
        }
        System.out.println("");
        executeCount++;
    }


    public int getExecuteCount() {
        return executeCount;
    }
}
