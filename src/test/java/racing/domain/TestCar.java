package racing.domain;

class TestCar extends Car {

  private TestCar(RandomGenerator randomGenerator, String name, int position) {
    super(randomGenerator, name);
    this.position = position;
  }

  static TestCar of(String name, int position) {

    TestRandomGenerator testRandomGenerator = new TestRandomGenerator(true);
    return new TestCar(testRandomGenerator, name, position);
  }
}
