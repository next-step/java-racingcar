package racing_game.view;

import java.util.List;
import racing_game.core.Positive;
import racing_game.core.SnapShot;
import racing_game.domain.Distances;

public class ResultView {

    public void showResult(SnapShot snapShot) {
        StringBuilder sb = new StringBuilder();
        for (Distances distance : snapShot.get()) {
            drawCars(distance.get(), sb);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private void drawCars(List<Positive> distances, StringBuilder sb) {
        for (Positive distance : distances) {
            sb.append("_ ".repeat(distance.toInt())).append("\n");
        }
    }


}
