package step3;

public class RacingMain {
    private static final String INPUT_TIMES = "시도할 회수는 몇 회 인가요";
    private static final String INPUT_CARS = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";

    public static void main(String[] args) {
        RacingInput racingInput = new RacingInput();
        String[] carNames = racingInput.inputForString(INPUT_CARS);
        int gameCoin = racingInput.inputForInt(INPUT_TIMES);

        RacingGame racingGame = new RacingGame(carNames);

        for(int i=0; i<gameCoin; i++) {
            racingGame.moveCars();
            RacingOutput.printRacing(racingGame.getRacingCarList());
        }

        RacingOutput.printWinner(racingGame.findWinner());
    }
}

