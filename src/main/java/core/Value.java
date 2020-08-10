package core;

public class Value {

    public static final String carGuide = "자동차 대수는 몇 대 인가요?";
    public static final String roundGuide = "시도할 회수는 몇 회 인가요?";

    public static String getCarGuide() {
        return carGuide;
    }
    public static String getRoundGuide() {
        return roundGuide;
    }

    public static int carCount;
    public static int round;

    public static int getCarCount() {
        return carCount;
    }
    public static int getRound() {
        return round;
    }

    public static void setCarCount(int carCount) {
        Value.carCount = carCount;
    }
    public static void setRound(int round) {
        Value.round = round;
    }
}
