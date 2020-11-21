package racingcar;

import java.util.Scanner;

public class InputView {

    public static final int CARNAME_MAXSIZE = 5;

    public static String[] inputCarNames(String inputMsg) throws Exception {
        System.out.println(inputMsg);
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.next();
        while(!CarRace.carNamesValidation(inputString)){
            return inputCarNames("자동차 이름은 5자를 초과할 수 없습니다. 다시 입력해주세요.");
        }
        return splitCarNames(inputString);
    }

    public static String[] splitCarNames(String carNames){
        return carNames.split(",");
    }

    public static int input(String inputMsg){
        System.out.println(inputMsg);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
