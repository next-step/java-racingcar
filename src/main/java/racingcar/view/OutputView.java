package racingcar.view;

import racingcar.domain.Position;

import java.util.List;

public class OutputView {
    public static void endMessage() {
        System.out.println("실행 결과");
    }

    public static void gameResult(List<Position> positions) {
        for (Position position : positions) {
            System.out.println(position.viewPosition());
        }
        System.out.println();
    }
}
