# Java racingcar

```
Put car names to race(separated by ',')
pobi,crong,gony
How many tries?
5
Race result(phase: 1)
pobi	: -
crong	: -
gony	: -

Race result(phase: 2)
pobi	: --
crong	: --
gony	: --

Race result(phase: 3)
pobi	: ---
crong	: ---
gony	: ---

Race result(phase: 4)
pobi	: ---
crong	: ---
gony	: ----

Race result(phase: 5)
pobi	: ----
crong	: ---
gony	: ----

🎉 Winner: [pobi, gony]
```

# Todo

## Step3

### InputView

- [x] getNumber
- [x] isInputRange

### Race

- [x] createCars
- [x] getRandom
- [x] roll
- [x] rollCars

### ResultView

- [x] printResult

## Step4

### InputView

- [x] Fix getNumber -> getTryNumber
- [x] Add getCarNames, parseInput
- [x] Fix createCar to get carNames

### Race

- [x] findWinners

### ResultView

- [x] Fix printResult to include car.name
- [x] printWinners

### Questions

#### Which is better?

- [ ] car.track -> car.position
- [ ] Fix printResult to generate '-' stemming from position