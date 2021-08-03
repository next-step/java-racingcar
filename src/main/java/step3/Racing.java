package step3;

import java.util.Random;

public class Racing {

    private Random random = new Random();
    private InputView inputView = new InputView();
    private ResultView resultView = new ResultView();

    public void race() {

        int carCount = inputView.getCarCount();
        int gameCount = inputView.getGameCount();

        checkInput(carCount, gameCount);

        int[][] result = getRaceResult(carCount, gameCount);

        resultView.printGameResult(result);
    }

    public int[][] getRaceResult(int carCount, int gameCount) {

        int[][] result = new int[gameCount][carCount];

        for(int i = 0; i < gameCount; i++) {
            for (int j = 0; j < carCount; j++) {

                int prev = 0; // 직전 결과
                if(i > 0) {
                    prev = result[i - 1][j];
                }
                
                result[i][j] = prev + getMoveNumber(random.nextInt(10));
            }
        }

        return result;
    }

    public int getMoveNumber(int number) {

        if(number >= 4) {
            return 1;
        }

        return 0;
    }

    public void checkInput(int carCount, int gameCount) {

        if(carCount == 0) {
            throw new IllegalArgumentException("자동차는 0대 이상이어야 합니다.");
        }

        if(gameCount == 0) {
            throw new IllegalArgumentException("게임 횟수는 0번 이상이어야 합니다.");
        }
    }

}
