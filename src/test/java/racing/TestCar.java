package racing;

class TestCar extends Car {

  public TestCar(RandomGenerator randomGenerator, String name, int position) {
    super(randomGenerator, name);
    this.position = position;
  }
}
