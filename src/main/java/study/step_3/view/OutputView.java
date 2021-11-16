package study.step_3.view;

public class OutputView {
    public void printResult(int distance) {
        for (int i = 0; i < distance; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void printDivider() {
        System.out.println();
    }
}
