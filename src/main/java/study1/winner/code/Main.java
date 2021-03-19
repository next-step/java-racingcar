package study1.winner.code;

import study1.winner.code.common.InputView;
import study1.winner.code.common.ResultView;
import study1.winner.code.service.Cars;
import study1.winner.code.service.Race;

public class Main {
  public static void main(String[] args) {
    String participants = InputView.getParticipants();
    int round = InputView.getRound();
    System.out.println("\n");
    Race race = new Race(round, participants);

    race.start().stream()
      .map(Cars::result)
      .forEach(ResultView::result);

    InputView.close();
  }

}
