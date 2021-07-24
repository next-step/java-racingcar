package step3;

public class ResultView {

    private final CarStadium carStadium;

    public ResultView(CarStadium carStadium) {
        this.carStadium = carStadium;
    }

    public void printResult() {
        carStadium.getAllCars().forEach(this::print);
        System.out.println("");
    }

    private void print(Car car) {
        for (int i = 0; i < car.getMovedCount(); i++) {
            System.out.print("-");
        }
        System.out.println("");
    }
}
