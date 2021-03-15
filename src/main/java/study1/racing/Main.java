package study1.racing;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int participant = InputView.getParticipants(scanner);
    int round = InputView.getRound(scanner);

    Race race = new Race(participant, round);
    for(RaceRound raceRound: race.start()) {
      System.out.println("");
      raceRound.getResult()
        .stream()
        .forEach((distance) -> ResultView.print(distance));
    }
    
    scanner.close();
  }
}
