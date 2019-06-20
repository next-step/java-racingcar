public class ResultView {
    public static void disPlayRacingResult(CarInfo carInfo) {
        String carStatus = "";

        for (int i = 0; i < carInfo.getCarPosition(); ++i)
            carStatus += "-";
        carInfo.setCarStatus(carStatus);
        System.out.println(carInfo.getCarName() + ": " + carInfo.getCarStatus());
    }

}
