package step5.strategy;

import step5.domain.dto.RacingInfomation;

import java.util.Scanner;

@FunctionalInterface
public interface InputStrategy {
    RacingInfomation question(Scanner scanner);
}
