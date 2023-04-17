package step3.printer;

import step3.Car;
import step3.Race;

public class PrinterImpl implements Printer{

    private final static String STATE = "-";

    @Override
    public void print(Race race) {
        System.out.println("실행결과");
        for(Car car : race.getCars()){
            System.out.println(STATE.repeat(car.getState()));
        }
        System.out.println();
    }
}
