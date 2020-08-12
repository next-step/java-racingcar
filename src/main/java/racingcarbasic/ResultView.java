package racingcarbasic;


public class ResultView {
    public ResultView() {
        System.out.println("실행 결과");
    }

    public void ResultPrint(int[] carMoveCount) {
        for (int p : carMoveCount) {
            System.out.println(new String(new char[p]).replace("\0", "-"));
        }
        System.out.println();
    }
}
