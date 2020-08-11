package cc.oakk.racing.view;

import cc.oakk.racing.domain.Car;
import cc.oakk.racing.domain.Ranking;
import cc.oakk.racing.view.printer.Printable;

public interface ResultView {
    void printResultHeader();
    void printCar(Printable<Car> car);
    void printRanking(Printable<Ranking> ranking);
}
