package racingCar.step5.view;

import java.util.Scanner;

public class ConsoleInputView implements InputView{
    private static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_TRY_RACING_COUNT_MESSAGE = "시도할 회수는 몇 회인가요?";
    private static final Scanner SCANNER = new Scanner(System.in);

    public String getCarNamesFromUser(){
        System.out.println(INPUT_CAR_NAME_MESSAGE);
        String carNames = SCANNER.nextLine();
        if(carNames.isBlank()){
            throw new IllegalArgumentException("자동차 이름을 입력하세요");
        }
        return carNames;
    }

    public int getRacingCountFromUser(){
        System.out.println(INPUT_TRY_RACING_COUNT_MESSAGE);
        int raceCountInput = SCANNER.nextInt();
        if(raceCountInput < 0){
            throw new IllegalArgumentException("레이싱 시도 횟수는 양수만 입력되어야 합니다");
        }
        return raceCountInput;
    }
}
