package cc.oakk.racing.view;

import cc.oakk.racing.Car;
import cc.oakk.racing.Ranking;
import cc.oakk.racing.printer.Printable;

public interface ResultView {
    void printResultHeader();
    void printCar(Printable<Car> car);
    void printRanking(Printable<Ranking> ranking);
}
