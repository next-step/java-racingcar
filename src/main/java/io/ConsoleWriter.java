package io;

public class ConsoleWriter {
    public void write(ResultView resultView) {
        resultView.getCars()
                .forEach(car -> System.out.println(car.distanceToString()));
        System.out.println();
    }

    public void writeHeader() {
        System.out.println("실행 결과");
    }
}
