package racing;

public class Main {
    public static void main(String[] args) {
        final String carNameAsk = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
        final String attemptsNumberAsk = "시도할 횟수는 몇 회 인가요?";

        Game game = new Game();
        Input input = new Input();

        game.createAttendedCarsWithName(input.askStringInput(carNameAsk));
        game.playGame(input.askIntInput(attemptsNumberAsk));
        input.close();
        Output.showWinner(game.getWinners());
    }
}
