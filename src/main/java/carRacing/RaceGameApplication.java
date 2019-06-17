package carRacing;

public class RaceGameApplication {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        System.out.println("자동차 대수는 몇대 인가요?");
        int numberOfCars = inputView.inputFromUser();
        System.out.println("시도핧 회수는 몇 회 인가요?");
        int numberOfLaps= inputView.inputFromUser();

        RacingGame racingGame = new RacingGame(numberOfCars, numberOfLaps);
        racingGame.startRace();
    }
}
