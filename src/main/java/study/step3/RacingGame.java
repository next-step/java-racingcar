package study.step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

public class RacingGame {
    private final static int INIT_INDEX = 0;
    private final static int FIRST_DISTINCTION_NUMBER = 1;
    private final static Pattern PATTERN = Pattern.compile("^[0-9]+$");
    private final static String ILLEGALARGUMENT_EXCEPTION_MASSEAGE = "올바르지 않은 값을 입력했습니다.";

    private int time= 0;
    private int carNumbers = 0;
    private List<Car> carList;

    private RacingGame(int time, int carNumbers) {
        this.time = time;
        this.carNumbers = carNumbers;
        carList = new ArrayList<>();
    }

    public List<Car> gameStart() {
        for (int i = INIT_INDEX; i < carNumbers; i++){
            carList.add(new Car(String.valueOf(i + FIRST_DISTINCTION_NUMBER)).move(time));
        }
        return carList;
    }

    public static class RacingGameBuilder{
        private int time= INIT_INDEX;
        private int carNumbers = INIT_INDEX;

        public RacingGameBuilder setCarNumbers(String carNumbers) {
            this.carNumbers = inputValidate(carNumbers);
            return this;
        }

        public RacingGameBuilder setTime(String time){
            this.time = inputValidate(time);
            return this;
        }

        private int inputValidate(String nextInt) {
            if(isNumber(nextInt)){
                return Integer.parseInt(nextInt);
            }
            throw  new IllegalArgumentException(ILLEGALARGUMENT_EXCEPTION_MASSEAGE);
        }

        private boolean isNumber(String nextInt) {
            return !Objects.isNull(nextInt) && !nextInt.isEmpty() && PATTERN.matcher(nextInt).matches();
        }

        public RacingGame build(){
            return new RacingGame(time,carNumbers);
        }

    }
}
