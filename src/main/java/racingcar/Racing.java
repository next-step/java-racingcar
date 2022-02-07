package racingcar;

public class Racing {

    public static void execute() {
        Car[] cars = IOClass.inputName();
        Race race = new Race();
        int times = IOClass.getTimes();
        race.repeatGame(cars, times);
        IOClass.printWinners(cars);
        return;
    }

}
