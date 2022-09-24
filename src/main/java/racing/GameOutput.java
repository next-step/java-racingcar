package racing;

public class GameOutput {

    private final String ASK_RACER_COUNT = "자동차 대수는 몇 대 인가요?";
    private final String ASK_ROUND_COUNT = "시도할 회수는 몇 회 인가요?";
    private final String ROUND_CLOSE = "라운드 종료";
    private final String COUNT_RACER = "전체 자동차 개수 : ";
    private final String COUNT_ROUND = "전체 라운드 : ";

    public void printAskRacerCount() {
        System.out.println(ASK_RACER_COUNT);
    }

    public void printAskRoundCount() {
        System.out.println(ASK_ROUND_COUNT);
    }

    public void printRacerAndCurrentLocation(Racer racer) {
        System.out.println(racer.printRacerAndCurrentLocation());
    }

    public void printDivideRound() {
        System.out.println(ROUND_CLOSE);
    }

    public void printRacerCount(int racerCount) {
        System.out.println(COUNT_RACER + racerCount);
    }

    public void printRoundCount(int roundCount) {
        System.out.println(COUNT_ROUND + roundCount);
    }


}
