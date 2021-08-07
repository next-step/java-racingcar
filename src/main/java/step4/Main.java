package step4;

import java.util.ArrayList;

public class Main {

  public static void main(String[] args) {
    String[] carNames = InputView.getCarNames();
    int numOfMove = InputView.getNumOfMove();

    CarRacing carRacing = new CarRacing(carNames, numOfMove);
    carRacing.startRacing();
    ArrayList<String> winnerList = carRacing.getWinnerList();
    for (String s : winnerList) {
      System.out.print(s + " ");
    }
  }
}
