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

        resultView.printTitle();
        playGame();
    }

    public static String[] initCarList(int carNum){
        String arr[] = new String[carNum];
        Arrays.fill(arr, "");
        return arr;
    }

    public static void move(int idx){
        Random rd = new Random();
        int random = rd.nextInt(MAX_NUM);
        if(random >= 4){
            ARR[idx] += "-";
        }
    }

    public static void playGame(){
        for(int i = 0; i<TRY_NUM; i++){
            for(int j = 0; j<CAR_NUM; j++){
                move(j);
            }
            resultView.printResult(ARR);
        }
    }
}
