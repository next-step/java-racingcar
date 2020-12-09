package racingcar;

import java.util.Scanner;

public class RacingRunner {

    private final Scanner scanner = new Scanner(System.in);
    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();

    private RacingCarController racingCarController;

    public void run() {
        this.racingCarController = this.inputView.inputCarAmount(this.scanner);
        this.playRound(this.inputView.inputRacingRound(this.scanner));
    }


    /**
     * 주어진 회차만큼 진행합니다.
     * @param round
     */
    public void playRound(int round) {
        System.out.println("실행 결과");
        for (int i = 0; i < round; i++) {
            this.racingCarController.moveForwardAll();
            this.resultView.printResult(this.racingCarController);
            System.out.println();
        }
    }

}
