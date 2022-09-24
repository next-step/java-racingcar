import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        InputReview inputReview = new InputReview();
        inputReview.inputCarNumber();
        inputReview.inputAttemptNumber();

        CarPlay carPlay = new CarPlay(inputReview);

        ResultView resultView = new ResultView(carPlay, inputReview);
        resultView.printTotalCarStatus();

    }
}
