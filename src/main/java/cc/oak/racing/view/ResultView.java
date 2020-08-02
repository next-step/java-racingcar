package cc.oak.racing.view;

import cc.oak.racing.Car;
import cc.oak.racing.printer.Printable;

public interface ResultView {
    void printResultHeader();
    void printCar(Printable<Car> car);
}
