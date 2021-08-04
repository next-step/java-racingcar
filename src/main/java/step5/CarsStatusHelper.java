package step5;

public class CarsStatusHelper {

    public static String getCarStatusView(int status) {
        return getRacingCarStatusBuilder(status).toString();
    }

    private static StringBuilder getRacingCarStatusBuilder(int status) {
        StringBuilder statusBuilder = new StringBuilder();
        for (int i = 0; i < status; i++) {
            statusBuilder.append("-");
        }
        return statusBuilder;
    }
}
