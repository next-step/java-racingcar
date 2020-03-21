package racing;

import racing.view.InputView;

public class RacingGame {

    private int[] carPositions ;

    public RacingGame(int carNum) {
        if (carNum == 0) {
            throw new IllegalArgumentException("차 대수는 0 이상이야 합니다.");
        }

        this.carPositions = new int[carNum];
    }

    public int[] move() {
        return carPositions;
    }

    public static void main(String[] args) {
        InputView inputView = new InputView();

        int carNum = inputView.inputInt("자동차 대수는 몇 대 인가요?");
        int time = inputView.inputInt("시도할 회수는 몇 회 인가요?");
    }

}
