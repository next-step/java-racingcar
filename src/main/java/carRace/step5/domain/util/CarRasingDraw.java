package carRace.step5.domain.util;

public class CarRasingDraw {

    public static String changeNumberToChar(int count) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < count; i++) {
            sb.append("-");
        }

        return sb.toString();
    }
}
