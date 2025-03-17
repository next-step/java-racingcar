public class Game {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        int carCount = inputView.promptInt("자동차 대수는 몇 대 인가요?");
        int roundCount = inputView.promptInt("시도할 회수는 몇 회 인가요?");

        ResultView resultView = new ResultView();
        resultView.present("실행 결과");

        Race race = new Race(carCount, roundCount);
        while (!race.isRaceFinished()) {
            race.runRound();
            resultView.presentCars(race.getCarPositions());
        }
    }
}
