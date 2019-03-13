package racinggame;

public class ResultView {

    public static void showCarPositions(int[] carPositions) {
        System.out.println("실행 결과");
        for( int curPosition : carPositions ) {
            showCarPosition(curPosition);
        }
        System.out.println();
    }

    private static void showCarPosition(int curPosition) {
        for( int i = 0; i < curPosition; ++i ) {
            System.out.print("-");
        }
        System.out.println();
    }
}