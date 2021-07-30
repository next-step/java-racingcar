package racingcargame;

public class ResultView {
    private String movingLine = "";

    public String move() {
        movingLine += "-";
        System.out.println(movingLine);
        return movingLine;
    }

    public String stop() {
        movingLine += "";
        System.out.println(movingLine);
        return movingLine;
    }

   public void showResultView() {
       System.out.println("\n실행 결과");
    }
}
