package step4.view;

import step4.domain.Car;

import java.util.List;

public class ResultView {
    public static final String DELIMETER = "-";

    public static void view(String data) {
        System.out.println(data);
    }

    public static String progressView(Car car) {
        StringBuilder sb = new StringBuilder();
        sb.append(car.getName());
        sb.append(":");
        for (int i = 0; i < car.getPosition(); i++) {
            sb.append(DELIMETER);
        }
        return sb.toString();
    }

    public static void result(List<String> winners) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < winners.size(); i++) {
            sb.append(winners.get(i));
            if (i != winners.size() - 1) {
                sb.append(",");
            }
        }
        if (winners.size() > 0) {
            sb.append("가 최종 우승했습니다.");
        }
        if (winners.size() == 0) {
            sb.append("우승자가 없습니다.");
        }
        System.out.println(sb.toString());
    }
}
