package cc.oakk.racing.view;

import cc.oakk.racing.domain.Car;
import cc.oakk.racing.domain.Ranking;
import cc.oakk.racing.view.printer.Printable;
import cc.oakk.racing.view.printer.Printer;
import cc.oakk.racing.view.printer.StandardPrinter;
import cc.oakk.racing.view.printer.StringPrinter;

public class ResultViewImpl implements ResultView {
    private final StringPrinter<Car> carPrinter;
    private final StringPrinter<Ranking> rankingPrinter;
    private final Printer<String> stringPrinter;

    public ResultViewImpl(StringPrinter<Car> carPrinter, StringPrinter<Ranking> rankingPrinter) {
        this.carPrinter = carPrinter;
        this.rankingPrinter = rankingPrinter;
        this.stringPrinter = new StandardPrinter();
    }

    public ResultViewImpl(StringPrinter<Car> carPrinter, StringPrinter<Ranking> rankingPrinter, Printer<String> stringPrinter) {
        this.carPrinter = carPrinter;
        this.rankingPrinter = rankingPrinter;
        this.stringPrinter = stringPrinter;
    }

    @Override
    public void printResultHeader() {
        stringPrinter.print("\n실행결과\n");
    }

    @Override
    public void printCar(Printable<Car> car) {
        car.print(carPrinter);
        stringPrinter.print("\n");
    }

    @Override
    public void printRanking(Printable<Ranking> ranking) {
        ranking.print(rankingPrinter);
        stringPrinter.print("\n");
    }
}
