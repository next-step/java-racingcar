package step4.view;

import step4.domain.Car;

import java.util.List;
import java.util.stream.Stream;

public class ResultView {

    public void render(Car car) {
        StringBuffer line = new StringBuffer();
        line.append(car.name() + " : ");
        for (int i = 0; i < car.position(); i++) {
            line.append("-");
        }
        System.out.println(line.toString());
    }

    public void renderWinner(List<Car> winners) {
        if (winners.size() > 0) {
            Stream<Car> stream = winners.stream();
            stream.forEach(s -> System.out.println(String.join(",", s.name()) + "가 최종 우승했습니다."));
        } else {
            System.out.println("우승자는 없습니다.");
        }
    }
}
