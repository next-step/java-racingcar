package study.calculator;

public class UserNumber {

    private final int number;

    private UserNumber(int number) {
        this.number = number;
    }

    public static UserNumber from(String userString){
        return new UserNumber(parsing(userString));
    }

    private static int parsing(String userString) {
        if(isBlank(userString)){
            return 0;
        }
        return Integer.parseInt(userString);
    }

    private static boolean isBlank(String userString) {
        return userString == null || userString.isEmpty() || userString.isBlank();
    }

    public int number() {
        return this.number;
    }
}
