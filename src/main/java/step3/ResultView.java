package step3;

public class ResultView {
    public static void viewResultMessage() {
        System.out.println("실행 결과");
        System.out.println();
    }

    public static void drawTravelDistance(Car car) {
        for (int i = 0; i < car.getTravelDistance(); i++) {
            System.out.print("-");
        }
    }

    public static void drawLineBreak() {
        System.out.println();
    }
}