package domain;

public class CarRandom {
    private CarRandom() {
    }

    public static int getRandomNumber() {
        return (int) (Math.random() * 10);
    }
}
