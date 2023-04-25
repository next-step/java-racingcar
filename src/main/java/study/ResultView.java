package study;

import java.util.Scanner;

public class ResultView {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("자동차의 대수는 몇 대 인가요?");
        int carCount = scan.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int tryCount = scan.nextInt();

        System.out.println("실행 결과");

    }



//    public void startRacing() {
//        Scanner scan = new Scanner(System.in);
//
//        System.out.println("자동차의 대수는 몇 대 인가요?");
//        int carCount = scan.nextInt();
//
//        System.out.println("시도할 회수는 몇 회 인가요?");
//        int tryCount = scan.nextInt();
//
//        System.out.println("실행 결과");
//    }
}
