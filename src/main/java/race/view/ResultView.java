package race.view;

import race.Position;
import race.Positions;

public class ResultView {
    private static final char POSITION_CHARACTER = '-';

    public static void showResultComment() {
        System.out.println("실행 결과");
    }

    public static void showPositions(Positions positions) {
        for (Position position : positions.getPositions()) {
            showPosition(position);
        }
        System.out.println();
    }

    private static void showPosition(Position position) {
        for (int i = 0; i < position.get(); i++) {
            System.out.print(POSITION_CHARACTER);
        }
        System.out.println();
    }
}
