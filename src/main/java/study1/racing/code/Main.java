package study1.racing.code;

public class Main {

  public static void main(String[] args) {
    int participant = InputView.getParticipants();
    int round = InputView.getRound();

    Race race = new Race(participant, round);
    race.start().stream()
      .map(RaceRound::getResult)
      .forEach(ResultView::print);

    InputView.close();
  }
}
