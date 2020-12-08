package racingcar;

import java.util.Scanner;

public class RacingRunner {

    private static final String RESULT_DASH = "-";

    private final Scanner scanner = new Scanner(System.in);
    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();

    private RacingCarController racingCarController;

    public void run() {
        this.inputCarAmount();
        this.playRound(this.inputRacingRound());
    }

    /**
     * 차의 대수를 입력받습니다.
     */
    private void inputCarAmount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        this.racingCarController = new RacingCarController(this.inputView.createRacingCars(scanner.nextInt()));
    }

    /**
     * 몇 회차까지 진행 할 지 입력받습니다.
     * @return round
     */
    private int inputRacingRound() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }

    /**
     * 주어진 회차만큼 진행합니다.
     * @param round
     */
    public void playRound(int round) {
        System.out.println("실행 결과");
        for (int i = 0; i < round; i++) {
            this.racingCarController.moveForwardAll();
            this.printResult();
            System.out.println();
        }
    }

    /**
     * 현재 결과를 출력합니다
     */
    private void printResult() {
        for (int distance : this.resultView.getNowDistance(this.racingCarController)) {
            this.printDash(distance);
        }
    }

    /**
     * 주어진 거리만큼 '-'를 출력합니다.
     * @param distance
     */
    private void printDash(int distance) {
        for (int i = 0; i < distance; i++) {
            System.out.print(RacingRunner.RESULT_DASH);
        }
        System.out.println();
    }
}
