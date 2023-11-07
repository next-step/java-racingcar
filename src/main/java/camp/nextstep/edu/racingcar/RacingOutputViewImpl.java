package camp.nextstep.edu.racingcar;

public class RacingOutputViewImpl implements RacingOutputView {

    @Override
    public void printRequestCarAmount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
    }

    @Override
    public void printRequestRoundAmount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
    }

    @Override
    public void printGameResult(RacingGameResult gameResult) {
        System.out.print("실행 결과\n" + gameResult.toString());
    }
}
