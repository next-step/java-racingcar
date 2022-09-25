package car_racing;

public class GameDashBoard {
    private static final String STRAIGHT_MARK = "-";
    private Cars cars;

    public GameDashBoard(Cars cars) {
        this.cars = cars;
    }

    public void show() {
        cars.straightCounts().forEach(straightCount -> {
            repeat(straightCount);
        });

        System.out.println("");
    }

    private void repeat(int straightCount) {
        for (int count = 0; count < straightCount; count++) {
            System.out.print(STRAIGHT_MARK);
        }
        System.out.println("");
    }
}
