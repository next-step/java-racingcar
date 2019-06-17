package racingcar.view;

import racingcar.exception.GameNotPreparedException;

import java.util.Scanner;

/**
 * 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
 *
 * 자동차 대수는 몇 대 인가요?
 * -> 3
 * 시도할 회수는 몇 회 인가요?
 * -> 5
 */
public class InputView {

  private Scanner scanner;
  private int rounds = -1;
  private int players = -1;

  public InputView() {
    this.scanner = new Scanner(System.in);
  }

  public int getRounds() {
    if (this.rounds == -1) throw new GameNotPreparedException("askQuestions method를 통해 Game에 필요한 질문에 먼저 답해주세요.");
    return rounds;
  }

  public int getPlayers() {
    if (this.rounds == -1) throw new GameNotPreparedException("askQuestions method를 통해 Game에 필요한 질문에 먼저 답해주세요.");
    return players;
  }

  public boolean askQuestions() {
    askNumberOfPlayers();
    askNumberOfRounds();

    return true;
  }

  void askNumberOfPlayers() {
    System.out.println("자동차 대수는 몇 대 인가요? \n");
    this.players = scanner.nextInt();
  }

  void askNumberOfRounds() {
    System.out.println("시도할 회수는 몇 회 인가요? \n");
    this.rounds = scanner.nextInt();
  }
}