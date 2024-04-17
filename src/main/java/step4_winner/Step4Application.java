package step4_winner;

import step4_winner.view.InputView;
import step4_winner.view.ResultView;

import java.util.Scanner;

public final class Step4Application {
    private Step4Application() {
        throw new UnsupportedOperationException("이 유틸 클래스는 인스턴스화할 수 없습니다.");
    }

    public static void main(String[] args) {
        // init
        InputView inputView = new InputView(new Scanner(System.in));
        ResultView resultView = new ResultView();
        CarRacingRunner carRacingRunner = new CarRacingRunner(inputView, resultView);

        // run races
        carRacingRunner.runRaces();
    }
}
