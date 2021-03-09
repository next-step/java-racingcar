package racing;

import racing.view.InputView;

public class App {
  public static void main(String[] args){
    InputView input = new InputView();
    int carCount = input.inputCarCount();
    int attempt = input.inputPeriod();
  }
}
