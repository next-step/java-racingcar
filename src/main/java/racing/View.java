package racing;

public class View {

    private static final String MARK = "-";

    public static void print(Cars cars) {
        for (int index = 0; index < cars.values().size(); index++) {
            System.out.println("Car " + getCarNumber(index) + " : " + convertPoisitonToMark(cars.values().get(index).position()));
        }
    }

    private static int getCarNumber(int index) {
        return index + 1;
    }

    private static String convertPoisitonToMark(int position) {
        return MARK.repeat(position);
    }

}
