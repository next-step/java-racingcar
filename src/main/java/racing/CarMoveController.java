package racing;


/**
 * 자동차 이동 제어기 (CarMoveController)
 *     - 책임
 *       - Car 객체의 움직임을 제어합니다.
 *       - 움직이는 경우, Car 객체에게 움직이라고 명령합니다.
 */
public class CarMoveController {

  private final CarMoveCondition carMoveCondition;
  private final RandomNumberGenerator randomNumberGenerator;

  public CarMoveController(CarMoveCondition carMoveCondition, RandomNumberGenerator randomNumberGenerator) {
    this.carMoveCondition = carMoveCondition;
    this.randomNumberGenerator = randomNumberGenerator;
  }


  public void move(Car car) {
    int randomNumber = randomNumberGenerator.generate();

    if (carMoveCondition.isMove(randomNumber)){
       car.move();
    }
  }





}
