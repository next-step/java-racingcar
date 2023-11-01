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
        int parseInt = Integer.parseInt(userString);
        if(parseInt<0) {
            throw new RuntimeException();
        }
        return parseInt;
    }

    private static boolean isBlank(String userString) {
        return userString == null || userString.isEmpty() || userString.isBlank();
    }

    public int number() {
        return this.number;
    }
}
