package racing;

public class ResultView {
    RacingVO racingVO;
    RacingGame racingGame;

    public ResultView(RacingVO racingVO, RacingGame racingGame) {
        this.racingVO = racingVO;
        this.racingGame = racingGame;
    }

    public void view() {
        int count = this.racingVO.getCount();
        System.out.println("실행결과");

        for(int i = 0; i < count; ++i) {
            this.viewResult(this.racingGame.move());
        }

    }

    public void viewResult(int[] carPositions) {
        int[] var2 = carPositions;
        int var3 = carPositions.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            int carPosition = var2[var4];
            System.out.println(this.printCar(carPosition));
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