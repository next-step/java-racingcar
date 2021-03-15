package study1.racing;

public class Main {

  public static void main(String[] args) {
    InputView inputView = new InputView();
    int participant = inputView.getParticipants();
    int round = inputView.getRound();

    Race race = new Race(participant, round);
    for(RaceRound raceRound: race.start()) {
      System.out.println("");
      raceRound.getResult()
        .stream()
        .forEach((distance) -> ResultView.print(distance));
    }
    inputView.closeScanner();
  }
}
