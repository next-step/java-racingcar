package domain;

import org.junit.platform.commons.util.StringUtils;

import java.util.Arrays;

public class Calculator {

        private int number;

        public Calculator() {
            this.number = 0;
        }

        private Operation findByOperation(String numbers) {
            return Operation.findByInputMark(numbers);
        }

        private void validationInput(String numberStr) {
            if(StringUtils.isBlank(numberStr)) {
                throw new IllegalArgumentException("빈 공백 문자열은 존재 할 수 없습니다.");
            }
        }

        private void validationInput(String[] numbers) {
            Arrays.stream(numbers)
                    .forEach(num -> validationInput(num));
        }


        public int calc(String input) {
            validationInput(input);

            String[] numbers = input.split(" ");
            validationInput(numbers);

            int numbers_length = numbers.length ;

            for(int i = 1; i < numbers_length; i+=2) {

                if( i-1 == 0 ) {
                    number =Integer.parseInt(numbers[i-1]);
                }

                Operation v =  findByOperation(numbers[i]);
                number = v.calculate(number, numbers[i+1]);

            }

            return number;
        }

}
