package racing;

public class RacingMain {
    public static void main(String[] args) {
        final int carsCount = new InputView().show("자동차 대수는 몇 대인가요?");
        final int attemptsCount = new InputView().show("시도할 횟수는 몇 회인가요?");

        final Racing racing = new Racing(carsCount, attemptsCount);
        RacingUtil.start(racing);
        System.out.println("\n실행 결과");
        racing.showResult();
    }
}
