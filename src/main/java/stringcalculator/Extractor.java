package stringcalculator;

import static stringcalculator.StringUtils.isInteger;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Extractor {

  private final List<Integer> numbers;
  private final List<Operator> operators;

  public Extractor(String[] tokens) {
    this.numbers = extractNumbers(tokens);
    this.operators = extractOperators(tokens);
  }

  public List<Integer> getNumbers() {
    return numbers;
  }

  public List<Operator> getOperators() {
    return operators;
  }

  private List<Integer> extractNumbers(String[] tokens) {
    return Collections.unmodifiableList(
        Arrays.stream(tokens)
            .filter(StringUtils::isInteger)
            .map(Integer::valueOf)
            .collect(Collectors.toList())
    );
  }

  private List<Operator> extractOperators(String[] tokens) {
    return Collections.unmodifiableList(
        Arrays.stream(tokens)
            .filter(token -> !isInteger(token))
            .map(Operator::operatorOf)
            .collect(Collectors.toList())
    );
  }


}
