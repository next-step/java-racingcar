package car.view;

public class WebInputValue {
    public static String[] getCarsName(String inputString) {
        return inputString.split(" ");
    }

    public static int getRacingCount(String inputStringRacingCount) {
        try {
            return Integer.parseInt(inputStringRacingCount);
        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }
}
