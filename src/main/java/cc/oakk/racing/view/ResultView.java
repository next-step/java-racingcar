package cc.oakk.racing.view;

import cc.oakk.racing.model.Car;
import cc.oakk.racing.model.Ranking;
import cc.oakk.racing.view.printer.Printable;

public interface ResultView {
    void printResultHeader();
    void printCar(Printable<Car> car);
    void printRanking(Printable<Ranking> ranking);
}
