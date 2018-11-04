package racing;

import java.util.List;

/**
 * 결과 UI
 */
public class ResultView {
    // 하이픈
    private static final String HYPEN = "-";

    private ResultView() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * 모든 차의 위치 출력
     *
     * @param positions 위치들
     */
    public static void printAll(List<Integer> positions) {
        System.out.println();
        positions.forEach(i -> {
            print(i);
            System.out.println();
        });
    }

    /**
     * @param position 위치
     */
    private static void print(int position) {
        for (int j = 0; j < position; j++) {
            System.out.print(HYPEN);
        }
    }
}
