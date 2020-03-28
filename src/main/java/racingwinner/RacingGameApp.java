package racingwinner;

public class RacingGameApp {

    public static void main(String[] args) {

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String[] carNames = InputView.cars();
        int carNumber = carNames.length;

        int roundNumber = 0;
        if (carNumber > 0) {
            System.out.println("시도할 회수는 몇 회 인가요?");
            roundNumber = InputView.rounds();
        }

        if (roundNumber > 0) {
            RacingGame racingGame = new RacingGame(carNames, roundNumber);
            racingGame.racing();
        }

    }
}
