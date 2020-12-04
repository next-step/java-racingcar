package step3;

import java.util.ArrayList;
import java.util.List;

import static step3.ViewManager.*;

public class View {

    public static void main(String[] args) {
        int value = inputMessageAboutCars();

        List<Driver> drivers = new ArrayList<>();
        for (int i=0; i<value; i++) drivers.add(new Driver());

        int numOfTry = inputMessageAboutTry();
        outputMessageAboutMove(drivers, numOfTry);
    }
}
