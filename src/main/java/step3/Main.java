package step3;

public class Main {
    public static void main(String[] args) {
        CarGame user = new CarGame();
        int carCnt = user.ask(Message.ASK_CAR_CNT);
        int tryCnt = user.ask(Message.ASK_TRY_CNT);

        System.out.println("자동차 대수 :" + carCnt);
        System.out.println("시도 횟수 :" + tryCnt);
        System.out.println();

        user = new CarGame(carCnt, tryCnt);
        user.playGame(tryCnt);
    }
}
