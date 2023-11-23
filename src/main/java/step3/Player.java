package step3;

public class Player {
    public static void main(String[] args) {
        InPutView inputView = InPutView.getInPutView();

        CarFactory carFactory = new CarFactory();
        Cars participatingCars = carFactory.make(inputView.howManyCars);

        Referee referee = new Referee();

        CarRacing carRacing = CarRacing.setting(participatingCars,referee,inputView.howManyTimesToTry);
        carRacing.start(new OutPutView());
    }

}
