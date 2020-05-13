package racingcar.view;

public class OutputView {
    private static final String OUTPUT_CHARACTERS = "-";

    public OutputView() {
        System.out.println("\n실행 결과");
    }

    public void printOut(int position) {
        for (int i = 0; i < position; i++) {
            System.out.print(OUTPUT_CHARACTERS);
        }
        System.out.println();
    }
}
