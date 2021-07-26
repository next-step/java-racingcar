package step4;

public class ResultView {

    public void printResult(CarStadium carStadium) {
        carStadium.getAllCars().forEach(this::print);
        System.out.println("");
    }

    private void print(Car car) {
        System.out.print(car.getCarName() + " : ");
        for (int i = 0; i < car.getMovedCount(); i++) {
            System.out.print("-");
        }
        System.out.println("");
    }
}
