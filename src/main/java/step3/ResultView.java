package step3;

public class ResultView {

    public ResultView() {}

    public void printStart() {
        System.out.println("\n실행 결과");
    }

    public void printRacingCar(int moveCount) {
        while (moveCount > 0) {
            System.out.print("-");
            moveCount--;
        }
        System.out.println();
    }

}
