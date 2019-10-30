package step2;

public class ResultView {

    public void printResultTitle() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void printCars(int[] carPositions) {
        for (int i : carPositions) {
            printCarLine(i);
            System.out.println();
        }
        System.out.println();
    }

    private void printCarLine(int position) {
        for (int i = 0; i < position; i++) {
            System.out.print('-');
        }
    }
}
