package racing.view;

import racing.domain.Car;
import racing.domain.Cars;

import java.util.List;
import java.util.stream.IntStream;

public class ResultView
{
    private ResultView() {}
    private static final ResultView resultView = new ResultView();
    private static final String SKID_MARK = "-";
    private static final StringBuilder BUILDER = new StringBuilder();

    public static ResultView getInstance()
    {
        return resultView;
    }

    public void draw(int tryNumber, List<Car> cars)
    {
        if (tryNumber == 0)
        {
            System.out.println("실행 결과");
        }
        cars.forEach(this::positionDraw);
        System.out.println();
    }

    private void positionDraw(Car car)
    {
        builderClear();
        IntStream.range(0, car.getPosition()).forEach(value -> BUILDER.append(SKID_MARK));

        System.out.printf("%s : %s%n", car.getCarName(), BUILDER);
    }

    public void winnerDraw(Cars cars)
    {
        System.out.println(cars.getWinner() + "가 최종 우승했습니다.");
    }

    private void builderClear()
    {
        BUILDER.delete(0, BUILDER.length());
    }
}
