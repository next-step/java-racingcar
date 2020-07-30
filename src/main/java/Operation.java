/**
 * Project : java-racingcar
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 12:10 오전
 */
public enum Operation {

    PLUS {
        @Override
        public int calculate(int answer, int nextNum) {
            return answer + nextNum;
        }
    },
    MINUS {
        @Override
        public int calculate(int answer, int nextNum) {
            return answer - nextNum;
        }
    },
    DIVISION {
        @Override
        public int calculate(int answer, int nextNum) {
            return answer / nextNum;
        }
    },
    MULTIPLY {
        @Override
        public int calculate(int answer, int nextNum) {
            return answer * nextNum;
        }
    }
    ;

    abstract public int calculate(int answer, int nextNum);

}
