public class RacingGame {

    private int time;
    private Car[] cars;

    public RacingGame(String[] carNames, int time) {
        this.time = time;

        this.cars = new Car[carNames.length];
        for (int i = 0; i < carNames.length; i++) {
            cars[i] = new Car(0, carNames[i]);
        }
    }

    public int getTime() {
        return this.time;
    }

    public Car[] getCars() { return this.cars; }

    public static void main(String[] args) {
        InputView inputView = new InputView();

        RacingGame racingGame = inputView.input();
        GameProgress gameProgress = new GameProgress();

        gameProgress.progress(racingGame);
    }

}
