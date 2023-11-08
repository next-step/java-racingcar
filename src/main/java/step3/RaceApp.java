package step3;

public class RaceApp {

    public static void main(String[] args) {
        MoveCarStatus moveCarStatus = new MoveCarStatus(InputView.readIntInput("자동차 대수는 몇 대 인가요?"));
        MoveCars moveCars = new MoveCars(InputView.readIntInput("시도할 회수는 몇 회 인가요?"), InputView.readIntInput("시도할 확률은 기준은 10중 얼마 인가요?"));
        moveCars.process(moveCarStatus, new ResultView(moveCarStatus.getResultMap()));
    }
}
