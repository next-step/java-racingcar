package racingcar.view;

import racingcar.domain.Position;

import java.util.List;

public class OutputView {
    public static final String POSITION_VIEW = "-";

    public static void endMessage() {
        System.out.println("실행 결과");
    }

    public static void gameResult(List<Position> positions) {
        for (Position position : positions) {
            System.out.println(viewPosition(position.position()));
        }
        System.out.println();
    }

    private static String viewPosition(int position) {
        return POSITION_VIEW.repeat(Math.max(0, position));
    }
}
