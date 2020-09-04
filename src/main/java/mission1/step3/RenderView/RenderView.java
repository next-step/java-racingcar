package mission1.step3.RenderView;

import mission1.step3.car.Car;
import java.util.List;

public class RenderView {

    private String expression;

    private RenderView(String expression) {
        this.expression = expression;
    }

    public static RenderView getInstance(String expression) {
        return new RenderView(expression);
    }

    public void showCarRace(List<Car> carList, int execNumber) {
        for (int i = 0; i < execNumber; i++) {
            for (Car car : carList) {
                System.out.println(renderExpression(car.getCarProgress(i)));
            }
            System.out.println("");
        }
    }

    private String renderExpression(int count) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 1; i <= count; i++) {
            stringBuilder.append(expression);
        }

        return stringBuilder.toString();
    }
}
