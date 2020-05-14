package study.step3;

import java.util.Scanner;

public class InputView {
    private final static String CAR_INPUT_QUESTION ="자동차 대수는 몇 대 인가요?";
    private final static String TRY_TIME_INPUT_QUESTION ="시도할 회수는 몇 회 인가요?";
    private final static  Scanner scanner = new Scanner(System.in);

    public InputView() {

        //InputLogic.scanUserInputValue();
    }

    public static int inputCarNumber(){
        System.out.println(CAR_INPUT_QUESTION);
        return scanner.nextInt();
    }

    public static int inputTryTime() {
        System.out.println(TRY_TIME_INPUT_QUESTION);
        return scanner.nextInt();
    }

    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame.RacingGameBuilder()
                                              .setCarNumbers(inputCarNumber())
                                              .setTime(inputTryTime())
                                              .build();

        for (int i = 0; i < racingGame.showTryTimes(); i++){
            racingGame.move(i+1);
        }

        System.out.println(racingGame.toString());

    }


}
