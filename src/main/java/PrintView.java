public class PrintView {

    public static void printTitle() {
        System.out.println("실행 결과");
    }

    public static void printCar(int distance) {
        for (int i = 0; i < distance; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
