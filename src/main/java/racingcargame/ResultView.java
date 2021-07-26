package racingcargame;

public class ResultView {
    String resultView = "";

    public void inputResultView(String inputResultView) {
        resultView = inputResultView;
    }

    public void showResultView() {
        System.out.println(resultView);
    }
}
