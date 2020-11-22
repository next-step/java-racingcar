package racingcar;

import java.util.Scanner;

public class InputView {

    public static final String carRaceCarNameInputMsg = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분). ";
    public static final String carRaceTryInputMsg = "시도할 회수는 몇 회 인가요? ";
    public static final int CARNAME_MAXSIZE = 5;
    public static final String carNameInputSizeErrorMsg = "자동차 이름은 " + CARNAME_MAXSIZE + "자를 초과할 수 없습니다. 다시 입력해주세요.";

    public static String[] inputRaceCarNames() throws Exception {
        System.out.println(carRaceCarNameInputMsg);
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.next();
        while(!CarRace.carNamesValidation(inputString)){
            return inputRaceCarNames(carNameInputSizeErrorMsg);
        }
        return splitCarNames(inputString);
    }

    public static String[] inputRaceCarNames(String inputMsg) throws Exception {
        System.out.println(inputMsg);
       return inputRaceCarNames();
    }

    public static String[] splitCarNames(String carNames){
        return carNames.split(",");
    }

    public static int inputRaceTryCount(){
        System.out.println(carRaceTryInputMsg);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
