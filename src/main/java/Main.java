import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("자동차 대수는 몇 대 인가요?");
        Scanner scanner = new Scanner(System.in);
        int carCount = Integer.parseInt(scanner.nextLine());
        System.out.println("시도할 횟수는 몇 회 인가요?");
        int tryCount = Integer.parseInt(scanner.nextLine());

        System.out.println("실행 결과");
        for (int i = 0; i < tryCount; i++) {
            // 시도 당 결과 출력
        }
    }
}
