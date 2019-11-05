package racingCar;

public class ResultView {

    public void createResultView(GameResult result) {
        for (Integer[] integers : result.getTimes()) {
            for (Integer integer : integers) {
                for (Integer i = 0; i < integer; i++) {
                    printCar();
                }
                printNewLine();
            }
            printGameTimes();
        }
    }

    private void printGameTimes() {
        System.out.println();
        System.out.println();
    }

    private void printNewLine() {
        System.out.println();
    }

    private void printCar() {
        System.out.print('-');
    }
}
