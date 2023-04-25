package study.car;

public class Car {
  String name;

  void validate() {
    if(name == null) {
      throw new NullPointerException();
    }

    if(name.length() > 5) {
      throw new IllegalStateException();
    }
  }
}
