package step3;

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
        Integer time = gameInformation.getTime();
        System.out.println("실행 결과");
        for (int now = 0; now < time; now++) {
            gameHistory.getHistory(now).print();
            System.out.println();
        }
        System.out.println(gameHistory.getWinners().toString() + "가 최종 우승 했습니다.");
    }
}
