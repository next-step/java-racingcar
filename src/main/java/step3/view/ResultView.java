package step3.view;

import step3.model.Cars;

import java.util.stream.IntStream;

public class ResultView
{
    private final Cars cars;

    public ResultView(Cars cars)
    {
        this.cars = cars;
    }

    public void draw()
    {
        System.out.println("실행 결과");
        print();

    }

    private void print()
    {
        IntStream.range(0, cars.getTryNumber())
            .forEach(value ->
            {
                cars.stream().forEach(car -> System.out.println(car.moving()));
                System.out.println("");
            });
    }
}
