package study;

import java.util.List;

class ResultView {

    private static final Character MARK = '-';

    static void printStartMessage() {
        System.out.println("실행 결과");
    }

    static void print(List<Car> cars) {
        cars.forEach(ResultView::printPosition);
        System.out.println();
    }

    private static void printPosition(Car car) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0, position = car.getPosition(); i < position; i++) {
            builder.append(MARK);
        }
        System.out.println(builder.toString());
    }

}
