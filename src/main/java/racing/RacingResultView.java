package racing;

public class RacingResultView {
    private static String separator = "-";

    static {
        System.out.println("실행 결과:");
    }

    public static void render(int[] result) {
        for (int position : result) {
            renderCarStatus(position);
            System.out.println();
        }
        System.out.println();
    }

    private static void renderCarStatus(int position) {
        for (int i = 0; i < position; i++) {
            System.out.printf(separator);
        }
    }
}
