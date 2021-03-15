package study1.racing;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int participant = InputView.getParticipants(scanner);
    int round = InputView.getRound(scanner);

    Race race = new Race(participant, round);
    race.start().stream()
      .map(RaceRound::getResult)
      .forEach(ResultView::print);

    scanner.close();
  }
}
