package step3.operation;

import java.util.Random;

public class Operation {

    /* 게임 실행 */
    public void gameStart(int numOfAtp, int numOfCars) {
        int[] game = new int[numOfCars];

        for(int i = 0; i < numOfAtp ; i++) {
            int[] result = makeRandomValue(numOfCars);
            progress(game, result);
            System.out.println();
        }
    }

    /* 진행 */
    public void progress(int[] game, int[] result) {
        for(int w = 0 ; w < game.length; w++) {
            game[w] = decideToMove(result[w], game[w]);
            showToMove(game[w]);
            System.out.println();
        }
    }

    /* Go or Stop 결정 */
    public int decideToMove(int result, int game) {
        if(result >= 4) {
            return game + 1;
        }
        return game;
    }

    /* '-' 표현 */
    public void showToMove(int game) {
        for(int z = 0 ; z < game ; z++) {
            System.out.print("-");
        }
    }

    /* 0~10 랜덤 수 생성 */
    public int[] makeRandomValue(int numOfCars) {

        Random random = new Random();
        int[] randomValue = new int[numOfCars];
        for(int i = 0; i < randomValue.length; i++) {
            randomValue[i] = random.nextInt(10);
        }
        return randomValue;
    }
}
