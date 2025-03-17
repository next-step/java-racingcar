package racing;

public class RacingCarApplication {

  public static void main(String[] args) {
    int carCount = InputView.getNumberOfCars();
    int roundCount = InputView.getNumberOfRounds();

    Racing racing = new Racing(carCount);

    System.out.println("실행 결과");

    for (int i = 0; i < roundCount; i++) {
      racing.simulateRace();
      ResultView.printRaceResult(racing.getCars());
    }
  }


}
