package racingcar;

public class Racing {

    public static void execute() {
        Car[] cars = IOClass.getName();
        if (!IOClass.checkCarName(cars)) {
            System.out.println("자동차 이름은 5자를 초과할 수 없습니다.");
            return;
        }
        Race race = new Race();
        int times = IOClass.getTimes();
        race.repeatGame(cars, times);
        IOClass.printWinners(cars);
        return;
    }

}
