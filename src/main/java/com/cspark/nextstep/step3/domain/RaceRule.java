package com.cspark.nextstep.step3.domain;

@FunctionalInterface
public interface RaceRule {

  Boolean apply(Dice dice);

}
