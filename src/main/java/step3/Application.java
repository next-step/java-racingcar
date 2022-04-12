package step3;

import step3.view.InputView;

public class Application {

    public static void main(String[] args) {
        RacingGame racingGame = InputView.show();
        System.out.println("실행 결과");
        racingGame.play();
    }

}
