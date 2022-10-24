package racingCar;

import java.util.Arrays;
import java.util.Random;

public class RacingCar {
    private static final int MAX_NUM = 10;
    private static String[] ARR;
    private static int CAR_NUM;
    private static int TRY_NUM;
    private static InputView inputView;
    private static ResultView resultView;

    public static void racingCar() {
        inputView = new InputView();
        resultView = new ResultView();

        CAR_NUM = inputView.carInput();
        TRY_NUM = inputView.tryInput();

        ARR = initCarList(CAR_NUM);
        System.out.println(Arrays.toString(ARR));
        resultView.printTitle();
        playGame();
    }

    public static String[] initCarList(int carNum){
        ARR = new String[carNum];
        Arrays.fill(ARR, "");
        return ARR;
    }

    public static int getRandomNum(int maxNum){
        Random rd = new Random();
        int random = rd.nextInt(maxNum);
        return random;
    }

    public static void move(int idx, int random){
        if(random >= 4){
            ARR[idx] += "-";
        }
    }

    public static void playGame(){
        int randomNum = 0;
        for(int i = 0; i<TRY_NUM; i++){
            for(int j = 0; j<CAR_NUM; j++){
                randomNum = getRandomNum(MAX_NUM);
                move(j, randomNum);
            }
            resultView.printResult(ARR);
        }
    }
}
