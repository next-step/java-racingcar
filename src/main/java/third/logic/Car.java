package third.logic;


import java.util.ArrayList;


public class Car {

    private static final int THRESHOLD = 4;
    private static final ArrayList<Car> carArrayList = new ArrayList<>();
    private final StringBuilder carLocation = new StringBuilder("-");

    public Car() {
        carArrayList.add(this);
    }

    public static ArrayList<Car> getCarArrayList() {
        return carArrayList;
    }

    public StringBuilder getCarLocation() {
        return carLocation;
    }

    public void carMove(int number) {
        if (number >= THRESHOLD) {
            carLocation.append("-");
        }
    }
}
