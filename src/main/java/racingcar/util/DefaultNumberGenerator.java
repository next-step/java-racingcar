package racingcar.util;


public class DefaultNumberGenerator implements NumberGenerator {

     @Override
     public int generator() {
          return (int)(Math.random() * 10);
     }
}
