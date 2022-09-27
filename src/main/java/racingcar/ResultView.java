package racingcar;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

public class ResultView {
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final String DASH = "-";

    public static void printStartMessage() {
        System.out.println("실행 결과");
    }

    public static void print(List<Car> cars) throws IOException {
        for (Car car : cars) {
            bw.write(DASH.repeat(car.getPosition()) + "\n");
        }
        bw.write("\n");
        bw.flush();
    }
}
