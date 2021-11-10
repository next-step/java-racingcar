package step3;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class GameOutput {

    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void println(String output) throws Exception {
        bw.write(output);
        bw.write('\n');
        bw.flush();
    }

    public static void printCarPaths(CarRacingGame carRacingGame) throws Exception {
        println(carRacingGame.getCars());
    }

    public static void println(Car[] cars) throws Exception {
        for (Car car : cars) {
            println(car);
        }
    }

    private static void println(Car car) throws Exception {
        println(getCarPath(car));
    }

    private static String getCarPath(Car car) {
        StringBuilder carPath = new StringBuilder();
        for (int i = 0; i < car.getPosition(); i++) {
            carPath.append('-');
        }
        return carPath.toString();
    }
}
