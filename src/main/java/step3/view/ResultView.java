package step3.view;

import step3.model.Car;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ResultView
{
    private final int tryNumber;
    public ResultView(int tryNumber)
    {
        this.tryNumber = tryNumber;
    }

    public void draw(List<Car> cars)
    {
        System.out.println("실행 결과");
        IntStream.range(0, tryNumber).forEach(value -> step(cars));
    }

    private void step(List<Car> cars)
    {
        cars.forEach(car -> positionDraw(car.moving()));
        System.out.println();
    }

    private void positionDraw(Car car)
    {
        StringBuilder builder = new StringBuilder();
        IntStream.range(0, car.getPosition()).forEach(value -> builder.append("-"));

        System.out.println(builder);
    }
}
