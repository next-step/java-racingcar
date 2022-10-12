package racing_game.view;

import java.util.Map;
import racing_game.core.Positive;
import racing_game.domain.SnapShot;
import racing_game.domain.CarName;

public class ResultView {

    public void showResult(SnapShot snapShot) {
        StringBuilder sb = new StringBuilder();
        snapShot.get().forEach((distanceMap -> {
            drawCars(distanceMap, sb);
            sb.append("\n");
        }));
        drawWinners(snapShot.getWinner(), sb);
        System.out.println(sb);
    }

    private void drawCars(Map<CarName, Positive> distanceMap, StringBuilder sb) {
        distanceMap.forEach(((carName, distance) -> {
            sb.append(carName)
                .append(" : ")
                .append("- ".repeat(distance.toInt()))
                .append("\n");
        }));
    }

    private void drawWinners(String winner, StringBuilder sb) {
        sb.append(winner)
            .append(" 가 최종 우승했습니다.");
    }

}
