package racing;

import racing.domain.RacingGame;
import racing.view.Printer;
import racing.view.Prompter;

public class RacingGameRunner {

    public static void main(String[] args) {
        RacingGame game = new RacingGame(
                Prompter.getStringsPrompt("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        );
        Printer.printGameResult(game.startRacing(Prompter.getIntPrompt("시도할 회수는 몇 회 인가요?")));
    }
}
