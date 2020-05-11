package com.string.calculator.service;

import com.string.calculator.model.Operation;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;

public class Caculator {

    private Queue<Double> cache = new ArrayDeque<>();

    public double caculator(String input) {
        String replacedInput = input.replace(" ", "");

        double value = castingCharacterToDoubleType(replacedInput.charAt(0));
        cache.add(value);

        double result;
        for (int i = 1 ; i < replacedInput.length(); i++) {
            char target = replacedInput.charAt(i);
            
            if (Character.isDigit(target)) {
                double converted = castingCharacterToDoubleType(target);
                cache.add(converted);
                continue;
            }

            double fromCache = cache.poll();
            result = Operation.getExactOperation(target).operate(fromCache, )
        }


    }

    private void calculateWithEachValue(double total, char value) {



        double fromCache = cache.poll();

    }

    private double castingCharacterToDoubleType(char value) {
        return (double) Character.digit(value, 10);
    }
}
