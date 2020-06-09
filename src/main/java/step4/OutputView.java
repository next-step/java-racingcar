package step4;

import java.util.Comparator;
import java.util.List;


public class OutputView {


    public static void start() {
        System.out.println("경기 시작");
    }

    public static void render(Result result) {
        result.getResult().forEach(car -> System.out.println(car.getName() + " : " + getDash(car.getPosition())));
        System.out.println();
    }

    private static String getDash(int position) {
        String dash = "";
        for(int i = 0; i < position; i++) {
            dash += "-";
        }
        return dash;
    }

    public static void winner(Result result) {
        List<Car> list = result.getResult();
        String name = "";
        int max = 0;
        list.sort(Comparator.comparing(Car::getPosition).reversed());
        for(int i = 0; i < list.size(); i++) {
            Car car = list.get(i);
            if(max <= car.getPosition()) {
                name += car.getName();
                max = car.getPosition();
            }
        }
        System.out.println(name + "가 최종우승했습니다.");
    }
}
