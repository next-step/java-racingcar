package racingcar;

public class ResultView {

    public static void print(GameResult result) {
        System.out.println("실행 결과\n");

        for (int i = 0; i < result.countRoundLength(); i++) {
            Round round = result.getRound(i);
            System.out.println(round.displayTraces() + "\n");
        }

        System.out.println(result.getWinnerId() + "가 최종 우승했습니다.");
    }
}
