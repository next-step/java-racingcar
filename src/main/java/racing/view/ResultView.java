package racing.view;

import racing.Car;
import racing.Racing;
import racing.exception.CarsNullPointerException;
import racing.exception.RacingNullPointerException;

import java.util.ArrayList;
import java.util.List;

public class ResultView {
    private final List<Car> cars;
    private final Racing racing;

    public ResultView(Racing racing, List<Car> cars) {
        this.racing = racing;
        this.cars = cars;
    }

    public void draw() {
        checkObjectsNull();

        List<StringBuilder> result = initResult(racing);
        System.out.println("실행 결과");

        for (int i = 0; i < racing.getAttemptsCount(); i++) {
            drawCars(result, i);
        }
    }

    private void checkObjectsNull() {
        if (racing == null) {
            throw new RacingNullPointerException();
        }

        if (cars == null) {
            throw new CarsNullPointerException();
        }
    }

    private List<StringBuilder> initResult(Racing racing) {
        List<StringBuilder> result = new ArrayList<>();
        for (int i = 0; i < racing.getAttemptsCount(); i++) {
            result.add(new StringBuilder());
        }
        return result;
    }

    private void drawCars(List<StringBuilder> result, int i) {
        for (int j = 0; j < cars.size(); j++) {
            boolean isMoved = cars.get(j).getStatues().get(i);
            initResult(result, j, isMoved);
            System.out.println(result.get(j));
        }

        System.out.println();
    }

    private void initResult(List<StringBuilder> result, int j, boolean isMoved) {
        if (!isMoved) {
            return;
        }

        result.get(j).append("-");
    }
}
