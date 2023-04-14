package racing;

public class RacingCarGame {

    public static Cars start() {
        InputView.input();
        Cars result = new Cars(InputView.getCarCount(), InputView.getMoveCount()).move();
        ResultView.print(result);
        return result; // 테스트를 위해 리턴
    }

}
