package race.car;

public class RunCarRace {

    private static String HOW_MANY_CARS = "자동차 댓수는 몇대인가요?";
    private static String HOW_MANY_ATTEMPTS = "시도할 회수는 몇 회 인가요?";

    public static void run() {

        System.out.println(HOW_MANY_CARS);
        int carCount = NumberInput.inputCount();
        System.out.println(HOW_MANY_ATTEMPTS);
        int tryCount = NumberInput.inputCount();

        ResultPrint.showCarImformation(new CarImformation(new int[carCount], tryCount));

    }

    public static boolean testRun(int carCount, int tryCount) {

        ResultPrint.showCarImformation(new CarImformation(new int[carCount], tryCount));

        return true;
    }

}
