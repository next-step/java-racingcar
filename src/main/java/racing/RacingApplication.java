package racing;

public class RacingApplication {

    public static void main(String[] args) {
        racingCarWithName();
    }

    public static void racingCarWithName() {
        ResultView.print("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String inputString = InputView.inputString();
        String[] carNames = inputString.split(",");
        ResultView.print("시도할 회수는 몇회인가요?");
        int round = InputView.input();

        Racing racing = new Racing(carNames, round);
        ResultView.print("");
        ResultView.print("실행결과");
        racing.race();
        racing.showWinner();
    }
}
