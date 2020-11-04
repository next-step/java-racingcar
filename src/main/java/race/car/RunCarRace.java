package race.car;

public class RunCarRace {

    private static String HOW_MANY_CARS = "자동차 댓수는 몇대인가요?";
    private static String HOW_MANY_ATTEMPTS = "시도할 회수는 몇 회 인가요?";


    public static void inputValue() {
        System.out.println(HOW_MANY_CARS);
        int carCount = NumberInput.inputCount();
        System.out.println(HOW_MANY_ATTEMPTS);
        int tryCount = NumberInput.inputCount();

        run(carCount, tryCount);
    }

    public static CarRaceInformation run(int carCount, int tryCount) {
        return repeatTryMoveCar(new CarRaceInformation(carCount, tryCount));
    }

    private static CarRaceInformation repeatTryMoveCar(CarRaceInformation carRaceInformation) {
        for (int i = 0; i < carRaceInformation.getTryCount(); i++) {
            repeatCar(carRaceInformation);

        }
        return carRaceInformation;
    }

    private static void repeatCar(CarRaceInformation carRaceInformation) {
        for (int i = 0; i < carRaceInformation.getCarCount(); i++) {
            carRaceInformation.getCarMoveCountArr()[i] = Car.moveCarCheck(carRaceInformation.getCarMoveCountArr()[i]);
        }
        ResultPrint.drawMoveCar(carRaceInformation.getCarMoveCountArr());
        System.out.print("\n");
    }
}
