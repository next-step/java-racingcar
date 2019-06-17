package racing;

public class RacingGameRunner {

    public static void main(String[] args) {
        RacingGame game = new RacingGame(
                Prompter.getPrompt("자동차 대수는 몇 대 인가요?"),
                Prompter.getPrompt("시도할 회수는 몇 회 인가요?")
        );
        game.startRacing();
    }
}
