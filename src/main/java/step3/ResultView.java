package step3;

public class ResultView {
    public static void display(int[] record) {
        for (int i = 0; i < record.length; i++) {
            System.out.println("-".repeat(record[i]));
        }
    }
}
