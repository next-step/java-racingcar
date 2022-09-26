package game;


public class Car {

    private int location;

    public int location() {
        return location;
    }

    public void changeLocation(int given) {
        if (isForward(given)) {
            location += 1;
        }
    }

    private static boolean isForward(int given) {
        return given >= 4;
    }

    public void showLocation() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < location(); i++) {
            stringBuilder.append("-");
        }
        System.out.println(stringBuilder);
    }
}
