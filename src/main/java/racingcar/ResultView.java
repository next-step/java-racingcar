package racingcar;

public class ResultView {

    private String result = "";

    public void setResult(String result) {
        this.result += result;
    }

    public void showResult() {
        System.out.println(result);
    }

    public void showWinner(String winner) {
        System.out.println(winner);
    }

}
