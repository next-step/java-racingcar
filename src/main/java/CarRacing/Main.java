package CarRacing;

import view.InputView;
import view.ResultView;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        InputView inputView = new InputView();
        inputView.insertCarCountAndTryCount();

        ResultView resultView = new ResultView(inputView.getCarCount(), inputView.getTryCount());
        resultView.startRacing();

    }
}
