package racingcar.validator;

public interface Validator <T1, T2>{
    T1 valid(T2 input);
}
