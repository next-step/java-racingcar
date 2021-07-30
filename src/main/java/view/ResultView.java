package view;

import CarRacing.Car;
import CarRacing.Cars;

import java.util.List;

public class ResultView {


    public void startRacing(List<Car> car) {
        StringBuilder stringBuilder = new StringBuilder();
        car.forEach(s -> stringBuilder.append(new String(new char[s.getPositon()]).replace("\0", "-") + "\n"));
        System.out.println(stringBuilder);
    }
}
