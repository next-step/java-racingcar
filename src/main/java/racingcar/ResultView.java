package racingcar;

public class ResultView {

    public void printLab(int labCount) {
        for (int i = 0; i < labCount; i++) {
            System.out.print("-");
        }
        printOneLine();
    }

    public void printOneLine() {
        System.out.println("");
    }
}
