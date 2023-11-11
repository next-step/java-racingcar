package step3.domain;

public class CarName {

    public static boolean verifyCarNames(String carNames) {
        //"abc,def,ghiss"
        String regex = "[a-z]+(,[a-z]+)*";
        if (!carNames.matches(regex)) {
            System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            return false;
        }
        return true;
    }

    public static String[] splitCarNames(String carNames) {
        return carNames.split(",");
    }
}
