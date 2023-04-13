package racingcar;

import racingcar.control.input.CarNamesInput;
import racingcar.control.input.StandardInput;
import racingcar.control.input.TrialInput;
import racingcar.control.input.validator.NamesValidator;
import racingcar.control.input.validator.PositiveValidator;
import racingcar.control.output.Printable;
import racingcar.control.output.RacingOutput;
import racingcar.control.output.RacingWinnersOutput;
import racingcar.model.Car;
import racingcar.model.Racing;
import racingcar.model.dto.CarDto;
import racingcar.model.dto.RacingDto;
import racingcar.strategy.RandomMovingStrategy;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class Program {
    public static void main(String[] args) {
        StandardInput<List<String>> namesInput = new CarNamesInput(new NamesValidator());
        StandardInput<Integer> trialInput = new TrialInput(new PositiveValidator());

        List<String> names = namesInput.getValue();
        int trials = trialInput.getValue();

        Racing racing = Racing.init(trials, names);

        while (!racing.isOver()) {
            racing.step();

            RacingDto dto = RacingDto.from(racing);
            Printable racingOutput = new RacingOutput(dto);
            
            racingOutput.print();
        }

        List<CarDto> winners = racing.winners()
                .stream()
                .map(CarDto::from)
                .collect(toList());

        Printable result = new RacingWinnersOutput(winners);
        result.print();
    }

}
