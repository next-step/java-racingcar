# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)





## STEP3

### 기능목록
    - 자동차 대수 및 시도할 횟수를 입력받는다
    - 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
    - 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.

### 구현기능

1. InputView
    - 자동차 대수 입력 (NumberOfCars)
    - 시도할 횟수 입력 (NumberOfAttempts)

1. ResultView
    - 자동차의 현재 위치를 출력해준다.

1. Car
    - boolean에 따른 position값 변동
        - random값이 4 이상일 경우 position을 증가 시킨다.

1. MoveStrategy
    - random값을 구한다. (0 ~ 9)
    - random값이 4 이상일 경우 true 아닐경우 false를 리턴한다.

1. Cars
    - Car객체를 관리하는 객체
    - 횟수에 따라 car의 move() 메소드를 호출해 이동시킨다.

1. Main
    - 자동차 대수와 시도할 횟수를 입력받는다.


### 피드백
    1. expression lambda 를 통해 가독성 향샹 
    > before
    IntStream.range(0, numberOfCars)
             .forEach(value -> {
                 tempCarList.add(new Car());
             });
    > after
    IntStream.range(0, numberOfCars)
             .forEach(value -> tempCarList.add(new Car()));
            
    2. stream forEach 를 사용 자제
       list API를 사용할때 stream ForEach 사용을 자제해야하는 이유 (https://jeong-pro.tistory.com/185)
       * 한줄요역 : 자료형에 데이터가 많으면 for문쓰고 데이터가 적으면 List는 ListApi forEach를 사용하는게 성능적으로 좋다.
       
    > before
    cars.getCarList().stream().forEach(car -> {
        System.out.println(repeat(car.getPosition()));
    });
    > after
    cars.getCarList().forEach(car -> System.out.println(repeat(car.getPosition())));
       
## STEP4

### 추가기능
    - 자동차에 이름을 부여한다. (5글자 이하)
    - 실행 결과를 보여줄때 자동차의 이름도 같이 출력한다.
    - 자동차의 이름을 입력받을때 쉼표(,)를 기준으로 구분한다.
    - 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한명 이상일 수 있다. 
      

### 구현기능

1. InputView
    - 자동차 이름 입력 (NameOfCars)
    - 시도할 횟수 입력 (NumberOfAttempts)

1. ResultView
    - 자동차의 이름과 현재 현재 위치를 출력해준다.
    - 우승자를 출력해준다.

1. Car
    - boolean에 따른 position값 변동
        - random값이 4 이상일 경우 position을 증가 시킨다.
    - name은 5글자를 초과할 수 없다.
    - stream API를 활용해 정렬하기 위해 Comparable를 상속한다.

1. MoveStrategy
    - random값을 구한다. (0 ~ 9)
    - random값이 4 이상일 경우 true 아닐경우 false를 리턴한다.

1. Cars
    - Car객체를 관리하는 객체
    - 횟수에 따라 car의 move() 메소드를 호출해 이동시킨다.
    - 자동차중 우승자를 구한다.
    - 컴마로 구분되는 이름을 입력받아 Car객체를 만든다.

1. Main
    - 자동차 이름과 시도할 횟수를 입력받는다.
    - 시도할 횟수만큼 자동차를 돌린다.
    - 우승자를 보여준다.
