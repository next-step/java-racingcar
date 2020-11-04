package racingcar;

public class Game {
    private static int gameCount;
    private static Car[] cars;

    public static void setGameCount(int count){
        gameCount = count;
    }

    public static void setCars(int count){
        cars = new Car[count];
    }
}
