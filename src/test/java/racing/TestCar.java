package racing;

class TestCar extends Car {

  private TestCar(RandomGenerator randomGenerator, String name, int position) {
    super(randomGenerator, name);
    this.position = position;
  }

  public static TestCar ofWithTrueRandomGenerator(String name, int position) {

    TestRandomGenerator testRandomGenerator = new TestRandomGenerator(true);
    return new TestCar(testRandomGenerator, name, position);
  }
}
