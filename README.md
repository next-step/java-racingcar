<<<<<<< HEAD
# 문자열 계산기
##string calculator 구현 기능 목록
[ x ] 사용자가 수식을 문자열로 입력한다.\
[ x ] 입력값이 빈 문자열이거나 null 이라면 IllegalArgumentException을 발생시킨다.\
[ x ] 그렇지 않다면 공백을 기준으로 문자열을 쪼개서 String 배열에 저장한다.\
[ x ] 수식의 첫번째 숫자를 result 변수에 저장한다.\
[ x ] 수식의 첫번째 연산자에 따라 첫번째 숫자와 두번째 숫자를 계산한다.\
[ x ] 연산자 자리에 + , - , * , / 외의 문자가 입력되었다면 IllegalArgumentException을 발생시킨다.\
[ x ] 0 으로 나눈다면 RuntimeException을 발생시킨다.
[ x ] 앞서 계산한 값은 result 변수에 저장하여 그 다음 숫자와 다시 계산한다.

# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## racing car 구현 기능 목록
[ x ] 사용자로부터 자동차 경주에 참가하는 자동차들의 이름을 문자열로 입력받는다. \
[ x ] 사용자로부터 게임을 시도할 횟수를 입력받는다.\
[ x ] 게임을 시도할 횟수로 음수를 입력할 경우 IllegalArgumentException을 발생시킨다.\
[ x ] 쉼표(,)를 기준으로 자동차 이름을 구별하여 racingcargame.model.RacingCar 객체를 생성한다.\
[ x ] 자동차 이름은 5자를 초과할 수 없다.\
[ x ] 생성한 racingcargame.model.RacingCar 객체들을 racingCars 리스트에 저장한다.\
[ x ] 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우 자동차는 전진한다.\
[ x ] 라운드마다 자동차들이 전진한 정도를 출력한다.\
[ x ] 전진한 정도(step)가 가장 높은 값을 구한다.\
[ x ] 그 값에 해당하는 자동차의 이름(name)들을 출력한다.

### racing car 의 기능
- 이름을 갖고 있다.
- 전진한다.
- 우승할 수 있다.

- 이름이 있어야 생성이 된다.
- 전진할 수도 있고 멈춰있을 수도 있다.
- 최고점과 같으면 우승한다.

### controller 의 기능
- 모든 자동차들을 관리한다.
- 이름을 입력시킨다.
- 입력된 이름으로 자동차들을 만든다.
    - input
    - split 
    - make
        - check name
- 라운드수를 입력시킨다.
- 라운드별로 자동차들에게 랜덤수 던져주고 자동차들을 움직이게 한다.
- 라운드별로 결과를 출력시킨다.
    - input
    - for each round
        - for each car
            - random number - run
            - output
- 최고점수를 구한다.
- 우승자들을 구한다.
=======
문자열 계산기
- [기능 구현 목록](https://github.com/LEE-Yerim/java-racingcar/blob/step2/src/StringCalculator.md)
- [main](https://github.com/LEE-Yerim/java-racingcar/tree/step2/src/main/java/stringcalculator)
- [test](https://github.com/LEE-Yerim/java-racingcar/tree/step2/src/test/java/stringcalculator)

자동차 경주 게임
- [기능 구현 목록](https://github.com/LEE-Yerim/java-racingcar/blob/step2/src/RacingCarGame.md)
- [main](https://github.com/LEE-Yerim/java-racingcar/tree/step2/src/main/java/racingcargame)
- [test](https://github.com/LEE-Yerim/java-racingcar/tree/step2/src/test/java/racingcargame)
>>>>>>> origin/step2
