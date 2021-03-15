package racing.view;

import java.util.Scanner;

public class InputView {

  private int totalPlayer;

  private int totalRound;

  private InputView() { }

  public static InputView newInstance(int totalPlayer, int roundCount) {
    InputView inputView = new InputView();
    inputView.totalPlayer = totalPlayer;
    inputView.totalRound = roundCount;
    return inputView;
  }

  public static InputView executeConsole() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("자동차 대수는 몇 대 인가요?");
    int totalPlayer = scanner.nextInt();
    System.out.println("시도할 회수는 몇 회 인가요?");
    int totalRound = scanner.nextInt();
    return InputView.newInstance(totalPlayer, totalRound);
  }

  public int getTotalPlayer() {
    return totalPlayer;
  }

  public int getTotalRound() {
    return totalRound;
  }
}
