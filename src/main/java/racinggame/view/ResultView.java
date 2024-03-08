package racinggame.view;

import racinggame.domain.Position;

import java.util.List;

public class ResultView {

    public static void display(List<Position> carPositions) {
        for (Position position : carPositions) {
            System.out.println("-".repeat(position.getPosition()));
        }
    }
}
