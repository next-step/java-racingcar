package racing.exception;

public class CarNameUnsuitableException extends RuntimeException {

  private static final String CAR_NAME_UNSUITABLE_MESSAGE = "자동차 이름이 적합하지 않습니다. 이름 : ";

  public CarNameUnsuitableException(String carName) {
    super(CAR_NAME_UNSUITABLE_MESSAGE + carName);
  }

}
