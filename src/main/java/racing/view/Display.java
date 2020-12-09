package racing.view;


import racing.domain.Car;
import racing.domain.ParticipateCars;

public class Display {
    private static final char sign = '-';
    public void printLine(String context) {
        System.out.println(context);
    }

    public void displayRacingResult(ParticipateCars participateCars) {
        participateCars.getCars()
                .forEach((car)->{
            printMoveCar(car);
        });
        printEmptyLine();
    }
    public void printMoveCar(Car car) {
        int totalMeter = car.totalMeter();
        String carName = car.getName();
        System.out.print(carName + ":");
        for(int i = 0; i < totalMeter; i++) {
            System.out.print(this.sign);
        }
        printEmptyLine();
    }

    public void printEmptyLine(){
        System.out.println();
    }

    public void printWinnner(String winners) {
        System.out.println( winners + "가 최종 우승 했습니다.");
    }
}
