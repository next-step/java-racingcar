package racing;

public class ResultView {
    private RacingVO racingVO;
    private RacingGame racingGame;

    public ResultView(RacingVO racingVO, RacingGame racingGame) {
        this.racingVO = racingVO;
        this.racingGame = racingGame;
    }

    public void view() {
        int count = racingVO.getCount();
        System.out.println("실행결과");
        for(int i = 0; i < count; ++i) {
            viewResult(racingGame.move());
        }
    }

    public void viewResult(int[] carPositions) {
        int length = carPositions.length;
        for(int i = 0; i < length; i++) {
            int carPosition = carPositions[i];
            System.out.println(printCar(carPosition));
        }
        System.out.println("###############################################");
    }

    public String printCar(int carPosition) {
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < carPosition; ++i) {
            sb.append("-");
        }
        return sb.toString();
    }
}