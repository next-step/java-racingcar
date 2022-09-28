package step3.view;

import step3.model.Car;

import java.util.List;
import java.util.stream.IntStream;

public class ResultView
{
    private ResultView() {}
    private static final ResultView resultView = new ResultView();
    private static final String SKID_MARK = "-";

    public static ResultView getInstance()
    {
        return resultView;
    }


    public void draw(List<Car> cars)
    {
        System.out.println("실행 결과");
        stepDraw(cars);
    }

    private void stepDraw(List<Car> cars)
    {
        cars.forEach(this::positionDraw);
        System.out.println();
    }

    private void positionDraw(Car car)
    {
        StringBuilder builder = new StringBuilder();
        IntStream.range(0, car.getPosition()).forEach(value -> builder.append(SKID_MARK));

        System.out.println(builder);
    }
}
