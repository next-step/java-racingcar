package study1.racing;

public class Main {

  public static void main(String[] args) {
    InputView inputView = new InputView();
    int participant = inputView.getParticipants();
    int round = inputView.getRound();

    Race race = new Race(participant, round);
    race.run();

    inputView.closeScanner();
  }
}
