package racing;

public class ResultView {

    public static void printTitle() {
        System.out.println("실행 결과");
    }

    public static void printMove(int position) {
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

}
