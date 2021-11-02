package step3;

public class main {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        RuleDto ruleDto = inputView.input();

        Game game = Game.of(ruleDto);
    }
}
