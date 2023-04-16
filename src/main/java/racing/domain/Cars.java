package racing.domain;

<<<<<<< HEAD
=======
import racing.domain.Car;
import racing.dto.GameResult;
import racing.util.RandomInt;

>>>>>>> e356fab2c (refactor Car 클래스를 필드로 가지는 일급컬렉션 추가)
import java.util.ArrayList;
import java.util.List;

public class Cars { // 일급컬렉션
    private List<Car> cars;

<<<<<<< HEAD
    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Car theCar(int index) {
        return this.cars.get(index);
    }

    public int size() {
        return this.cars.size();
    }

    public Cars playOnceTurn() {

        List<Car> movedCars = new ArrayList<>();
        RandomGameRule randomGameRule = new RandomGameRule();

        for (int i = 0; i < this.cars.size(); i++) {
            int randomNumber = randomGameRule.getPossibleInt();
            Car car = this.cars.get(i).move(randomNumber);
            movedCars.add(car);
        }
        return new Cars(movedCars);
    }

    public List<String> findWinners() {

        List<String> winners = new ArrayList<>();
        int maxLocation = maxLocation();

        for (int i = 0; i < this.cars.size(); i++) {
            addOnlyWinner(winners, maxLocation, i);
        }
        return winners;
    }

    private void addOnlyWinner(List<String> winners, int maxLocation, int i) {
        if (checkWinner(maxLocation, this.cars.get(i))) {
            winners.add(this.cars.get(i).name());
        }
    }

    private boolean checkWinner(int maxLocation, Car car) {
        if (car.isWinner(maxLocation)) {
            return true;
        }
        return false;
    }

    public int maxLocation() {
        int maxLocation = 0;
        for (int i = 0; i < this.cars.size(); i++) {
            maxLocation = this.cars.get(i).bigger(maxLocation);
        }
        return maxLocation;
=======
    public Cars(List<Car> cars){
        this.cars = cars;
    }

    public List<Car> getCars(){
        return this.cars;
    }

    public GameResult playOnceTurn() {
        List<Integer> onceResult = new ArrayList<>();

        for(int i = 0; i < cars.size(); i++) {
            this.cars.get(i).move(RandomInt.makeRandomInt());
            onceResult.add(this.cars.get(i).getLocation());
        }
        return new GameResult(onceResult);
>>>>>>> e356fab2c (refactor Car 클래스를 필드로 가지는 일급컬렉션 추가)
    }
}
