package game.racing;

/**
 * @author : yusik
 * @date : 2019/10/26
 */
public class RacingGameSettings {

    public static String TEXT_NUMBER_OF_CAR = "자동차 대수는 몇 대 인가요?";
    public static String KEY_NUMBER_OF_CAR = "numberOfCar";
    public static String TEXT_NUMBER_OF_TIMES = "시도할 회수는 몇 회 인가요?";
    public static String KEY_NUMBER_OF_TIMES = "numberOfTimes";

    private int numberOfCar;
    private int numberOfTimes;

    public int getNumberOfCar() {
        return numberOfCar;
    }

    public void setNumberOfCar(int numberOfCar) {
        this.numberOfCar = numberOfCar;
    }

    public int getNumberOfTimes() {
        return numberOfTimes;
    }

    public void setNumberOfTimes(int numberOfTimes) {
        this.numberOfTimes = numberOfTimes;
    }
}
