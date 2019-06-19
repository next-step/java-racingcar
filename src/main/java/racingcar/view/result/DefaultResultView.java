package racingcar.view.result;

import java.util.List;

public class DefaultResultView implements ResultView {

    @Override
    public void printHeader() {
        System.out.println("\n실행 결과");
    }

    @Override
    public void printBody(List<Integer> carPositions) {
        carPositions.stream()
                .forEach(DefaultResultView::printPosition);
        System.out.println();
    }

    @Override
    public void printFooter() {}

    private static void printPosition(Integer position) {
        for (int i=0; i<position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
