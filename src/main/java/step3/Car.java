package step3;

import java.util.Scanner;

public class Car {
    private int tryCnt;
    private int move;

    public Car(int tryCnt) {
        this.tryCnt = tryCnt;
        this.move = 0;
    }

    public int getTryCnt() {
        return tryCnt;
    }

    public void setTryCnt(int tryCnt) {
        this.tryCnt = tryCnt;
    }

    public int getMove() {
        return move;
    }

    public void setMove(int move) {
        this.move = move;
    }

    public static void main(String[] args) {
        //자동차 수 입출력
        Scanner sc = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carCnt = sc.nextInt();
        System.out.println(carCnt);

        //시도횟수 입출력
        sc = new Scanner(System.in);
        System.out.println("시도할 회수는 몇 회 인가요?");
        int tryCnt = sc.nextInt();
        System.out.println(tryCnt);

    }

}
