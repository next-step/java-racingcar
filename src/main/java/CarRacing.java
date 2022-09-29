public class CarRacing {
    public static void main(String[] args) {
        int carCount = CarRacingInputView.getCarCountFromUser();
        int trialCount = CarRacingInputView.getTrialCountFromUser();

        System.out.println(carCount + " " + trialCount);
    }
}
