package racing;

public class ResultView extends View<Void, Car> {
    @Override
    public Void show(Car car) {
        for (int i = 0; i < car.getDistance(); i++) {
            System.out.print("-");
        }
        System.out.println();

        return null;
    }
}
