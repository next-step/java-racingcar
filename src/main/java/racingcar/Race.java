package racingcar;

public class Race {

    public static void execute() {
        Car[] cars = IOClass.getName();
        if (!IOClass.checkCarName(cars)) {
            System.out.println("자동차 이름은 5자를 초과할 수 없습니다.");
            return;
        }

        Race race = new Race();
        int times = IOClass.getTimes();
        repeatGame(cars, times);
        IOClass.printWinners(cars);
        return;
    }

    public static int getMaxScore(Car[] cars) {
        int maximum = 0;
        for (int i = 0; i < cars.length; i++) {
            maximum = Math.max(maximum, cars[i].getPosition());
        }
        return maximum;
    }

    public static void repeatGame(Car[] cars, int times) {
        while ((times--) > 0) {
            for (int i = 0; i < cars.length; i++) {
                int randomNumber = Race.getRandomNumber();
                Race.compareWithFour(cars, i, randomNumber);
            }
            IOClass.printCurrentPosition(cars);
            System.out.println();
        }
    }

    static int getRandomNumber() {
        int randomNumber = (int) Math.floor(Math.random() * 10);
        return randomNumber;
    }

    public static void compareWithFour(Car[] cars, int idx, int randomNumber) {
        if (randomNumber >= 4) {
            cars[idx].go();
        }
        return;
    }
}
