package racing;

public class RacingResultView {
    private String separator = "-";

    public void render(int[] result) {
        for (int position : result) {
            for (int i = 0; i < position; i++) {
                System.out.printf(separator);
            }
            System.out.println();
        }
        System.out.println();
    }
}
