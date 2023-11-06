public class Racing {

    private final Car[] cars;
    private final int round;

    public Racing(Car[] cars, int round) {
        this.cars = cars;
        this.round = round;
    }

    public void start() {
        System.out.println("실행 결과");
        for (int i = 0; i < this.round; i++) {
            startRound();
            ResultView.print(cars);
        }
    }

    private void startRound() {
        for (Car car : cars) {
            car.move(NumberUtil.createRandomNumber());
        }
    }
}
