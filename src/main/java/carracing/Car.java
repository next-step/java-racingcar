package carracing;

public class Car {
    int speed;
    String bracket;


    public static String straight(int speed) {
        String result = "";
        StringBuilder builder = new StringBuilder();

        if (speed < 4) {
            return stop();
        }

        for (int i = 0; i < speed; i++) {
            result = builder.append("-").toString();
        }
        return result;
    }

    public static String stop() {
        return "";
    }
}
