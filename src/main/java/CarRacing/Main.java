package CarRacing;

import view.InputView;
import view.ResultView;

public class Main {


    public static void main(String[] args) {

        InputView inputView = new InputView();

        ResultView resultView = new ResultView();

        resultView.setStringBuilder(inputView.startInsertReturnStringBuilder());
        resultView.getResultRacing();

    }
}
