package racingcar;

public class RacingView {
    public RacingGame game;

    public RacingView(RacingGame game) {
        this.game = game;
    }

    // NOTE: Car 보다 작은 단위로 convert 하지 않도록 한다.
    protected String convertCar(Car car) {
        int position = car.getPosition();
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < position; j++) {
            sb.append("-");
        }
        return sb.toString();
    }

    public void print() {
        this.game.printCars(car -> {
            String convertedCar = this.convertCar(car);
            System.out.println(convertedCar);
        });
        System.out.println();
    }
}
