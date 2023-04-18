package step3;

public class Car {

    private static int location;

    public static int move(int numberValue) {
        if (numberValue >= 4) {
            return ++location;
        }
        return location;
    }
}
