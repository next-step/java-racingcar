package step4;

public class ResultView {

    private final GameHistory gameHistory;
    private final GameInformation gameInformation;

    private ResultView(GameHistory gameHistory, GameInformation gameInformation) {
        this.gameHistory = gameHistory;
        this.gameInformation = gameInformation;
    }

    public static ResultView from(GameHistory gameHistory, GameInformation gameInformation) {
        return new ResultView(gameHistory, gameInformation);
    }

    public void view() {

        System.out.println("실행 결과");
        System.out.println(gameHistory.toString(gameInformation.getTime()));
    }
}
