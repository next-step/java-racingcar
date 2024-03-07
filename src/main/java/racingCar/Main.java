package racingCar;

public class Main {

  public static void main(String[] args) {
    InputView inputView = new InputView();
    ResultView resultView = new ResultView();

    resultView.print("자동차 대수는 몇 대 인가요?");
    int carNum = inputView.inputInteger();

    resultView.print("시도할 회수는 몇 회 인가요?");
    int gameTryNum = inputView.inputInteger();

  }

}
