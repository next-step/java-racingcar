package racing;

public class OutputView {

    public static void outputCarMovement(Car car) {
        int movementCount = car.currentPosition();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < movementCount; i++) {
            stringBuilder.append("-");
        }
        System.out.println(stringBuilder);
    }
}
