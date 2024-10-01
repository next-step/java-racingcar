package racingCar.step3;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_CAR_COUNT_MESSAGE = "자동차 대수는 몇 대인가요?";
    private static final String INPUT_TRY_RACING_COUNT_MESSAGE = "시도할 회수는 몇 회인가요?";
    private static final Scanner scanner = new Scanner(System.in);

    public static int getCarCountInputFromUser(){
        System.out.println(INPUT_CAR_COUNT_MESSAGE);
        int carCountInput = scanner.nextInt();
        if(carCountInput < 0){
            throw new IllegalArgumentException("자동차 대수는 양수만 입력되어야 합니다");
        }
        return carCountInput;
    }

    public static int getRacingCountInputFromUser(){
        System.out.println(INPUT_TRY_RACING_COUNT_MESSAGE);
        int raceCountInput = scanner.nextInt();
        if(raceCountInput < 0){
            throw new IllegalArgumentException("레이싱 시도 횟수는 양수만 입력되어야 합니다");
        }
        return raceCountInput;
    }

    private InputView(){}
}
