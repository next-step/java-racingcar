//package racing;
//
//import racing.car.Car;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class ParticipatingCars {
//
//    private final List<Car> participatingCars = new ArrayList<>();
//
//    private final int initPosition = 0;
//
//    public ParticipatingCars(String inputNames) {
//        String[] names = inputNames.split(",");
//        for (String name : names) {
//            this.participatingCars.add(new Car(name, initPosition));
//        }
//    }
//
//    public List<Car> cars() {
//        return this.participatingCars;
//    }
//
//    public int numberOfCars() {
//        return this.participatingCars.size();
//    }
//}
