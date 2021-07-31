package view;

import CarRacing.Car;
import CarRacing.Cars;

import java.util.List;

public class ResultView {


    public void printCarPosition(List<Car> car) {
        StringBuilder stringBuilder = new StringBuilder();
        car.forEach(s -> stringBuilder.append(printPosition(s.getPosition())));
        System.out.println(stringBuilder);
    }

    private String printPosition(int position) {
        return new String(new char[position]).replace("\0", "-") + "\n";
    }
}
