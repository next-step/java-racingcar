package racingcarwinner;

public class Round {

    public void play(Cars cars){
        for (int i = 0; i < cars.getCount(); i++) {

            Car car = cars.getCar(i);

            ResultView.carNameView(car);
            if(NumberComparator.isAndAboveValue(RandomGenerator.getRandomNumber())){
                car.move();
            }
            ResultView.carPositionView(car);
        }
    }
}
