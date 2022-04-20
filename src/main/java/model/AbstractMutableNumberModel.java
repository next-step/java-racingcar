package model;

public abstract class AbstractMutableNumberModel implements NumberModel {

  protected int value;

  public AbstractMutableNumberModel(int value) {
    validateValue(value);
    this.value = value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public int toInt() {
    return value;
  }

  /*
   setValue()를 protected로 선언하여 이 추상클래스의 구현클래스만 사용할 수 있도록 하여,
   외부에서 setter를 직접 사용하는 것을 막도록 한다.
   value를 변경하고 싶은 경우는 클래스가 이 setter를 내부적으로 호출하는 public method를 만들어야한다.
   */
  protected void setValue(int value) {
    this.value = value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AbstractMutableNumberModel that = (AbstractMutableNumberModel) o;
    return value == that.value;
  }

  abstract public void validateValue(int value);
}
