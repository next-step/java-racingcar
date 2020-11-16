package racingcar;

import java.util.Scanner;

public class InputView {

    public static final int CARNAME_MAXSIZE = 5;

    public static String[] inputCarNames(String inputMsg) throws Exception {
        System.out.println(inputMsg);
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.next();
        while(!carNamesValidation(inputString)){
            return inputCarNames("자동차 이름은 5자를 초과할 수 없습니다. 다시 입력해주세요.");
        }
        return splitCarNames(inputString);
    }

    public static boolean carNamesValidation(String carNames){
        String[] names = splitCarNames(carNames);
        for(String name : names){
            if(name.length()> CARNAME_MAXSIZE){
                System.out.println(name);
                return false;
            }
        }
        return true;
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
