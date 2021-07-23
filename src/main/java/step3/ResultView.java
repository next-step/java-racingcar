package step3;

public class ResultView {

    public static void showCurrentCarLocation(int movedCount) {
        for (int i = 0; i < movedCount; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
