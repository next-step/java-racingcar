# 자동차 경주 게임

## 진행 방법

* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정

* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 기능 요구사항

초간단 자동차 경주 게임을 구현한다.

주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.

사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.

전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.

자동차의 상태를 화면에 출력한다.

어느 시점에 출력할 것인지에 대한 제약은 없다.

## 기능 구현 목록 TODO-list

### Contoller

[ ] InputView로부터 입력 받은 자동차 대수를 통해, 해당 대수만큼의 자동차 개체 들을 생성 할 수 있다.

- [ ] 입력 받은 회수가 숫자가 아닐경우, IllegalArgumentException을 발생시켜, 프로그램을 종료한다.

- [ ] 입력 받은 회수가 0회 이하의 숫자일경우, IllegalArgumentException을 발생시켜, 프로그램을 종료한다.

- [ ] 입력 받은 자동차 대수만큼, 자동차 개체를 생성하고, 해당 개체들을 이용하여, 자동차 개체 일급 컬렉션인 Cars개체를 생성한다.

[ ] InputView로부터 입력 받은 시도 회수를 통해, 해당 회수만큼 자동차 경주게임을 플레이 할 수 있다.

- [ ] 입력 받은 회수가 숫자가 아닐경우, IllegalArgumentException을 발생시켜, 프로그램을 종료한다.

- [ ] 입력 받은 회수가 0회 이하의 숫자일경우, IllegalArgumentException을 발생시켜, 프로그램을 종료한다.

- [ ] 입력 받은 회수 만큼, Cars개체에게 '소유하고 있는 자동차 개체들을 전진 또는 멈추라'라는 메시지를 전달한다.

[ ] 매 회 플레이가 끝나면, OutputView에, 현재 자동차 개체들의 진행상태를 반환 할 수 있다.

- [ ] 한 회 플레이가 끝나면, Cars개체에게, '소유하고 있는 자동차 개체들의 전진 거리 목록'를 반환하라는 메시지를 전달하여, 반환받은 리스트를 OutputView에
  전달한다.

### Domain Models

#### Car

[x] Client는, 1대의 자동차 개체를 생성할 수 있다.

[x] Client는, 다음의 조건을 통해, 1대의 자동차를 한칸 전진 또는 멈출 수 있다.

- [x]  자동차 전진 조건 : [0..9] 사이의 random값을 구한 후, random값이 4이상일경우 전진, 3이하의 값이면 멈춘다.

[x] Client는, 원하는 전진 정책과, 전진 조건을 지정하여, 자동차 개체를 생성할 수 있다.

- [x]  주어진 전진 정책이 Null일경우, IllegalArgumentException을 발생시켜, 프로그램을 종료한다.
- [x]  주어진 전진 조건이 Null일경우, IllegalArgumentException을 발생시켜, 프로그램을 종료한다.

#### Cars (1급컬렉션)

[x] Client는, 자동차 개체 목록을 이용하여, Cars 개체를 생성 할 수 있다.

- [x]  주어진 자동차 개체 목록이 Null일경우, IllegalArgumentException을 발생시켜, 프로그램을 종료한다.
- [x]  주어진 자동차 개체 목록이 Empty일경우, IllegalArgumentException을 발생시켜, 프로그램을 종료한다.
- [x]  주어진 자동차 개체 목록중, Null 개체가 존재 할 경우, IllegalArgumentException을 발생시켜, 프로그램을 종료한다.

[x] Client는, Cars 개체에게, '소유하고 있는 자동차 개체들을 전진 또는 멈추라'라는 메시지를 전달할 수 있다.

[x] Client는, Cars 개체에게, '소유하고 있는 자동차 개체들의 전진 거리 목록'를 반환받을 수 있다.

### View

#### InputView

[ ] 사용자로부터, 경주 할 자동차 대수를 입력 받을 수 있다.

[ ] 사용자로부터, 몇번의 전진을 시도 할 것인지 입력받을 수 있다.

#### OutputView

[ ] 각 회수별, 각 자동차의 전진 실행 상태를 출력할 수 있다.

## Hints

값을 입력 받는 API는 Scanner를 이용한다. 

랜덤 값은 자바 java.util.Random 클래스의 nextInt(10) 메소드를 활용한다.

## 프로그래밍 요구사항

모든 로직에 단위 테스트를 구현. 단, UI(System.out, System.in) 로직은 제외.

## 기능 목록 및 commit 로그 요구사항

기능을 구현하기 전에 README.md 파일에 구현할 기능 목록을 정리해 추가한다.

git의 commit 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위로 추가한다.

## Improvement

### ERROR Message

## Learn from Questions

### Q: 랜덤 값을 테스트하기위해서는 확률말고 다른 옵션은 없을까?

라이브러리가 버그가 나지 않는 이상 믿고쓰라는 의견도 당연히 있겠지만, 
프로덕션 코드에서 사용하는 랜덤값이  제대로 작동한다는 검증이 필요하지 않나?

### Learned: Java8 Random vs ThreadLocalRandom

#### TL;DR
- java.util.Random instance는 ThreadSafe하나, 동시성제어가 없어, 멀티쓰레딩 환경에서 인스턴스를 동시에 이용하면, 시드업데이트시 경합이 발생하여 성능이 저하된다. 
- 따라서, 멀티쓰레딩 환경에선 [ThreadLocalRandom](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/concurrent/ThreadLocalRandom.html#nextInt(int,int)) 이용하자.
- 또한, 암호화로 안전하지 않기에, 암호로 안전한 난수를 생성할때는, [SecureRandom](https://docs.oracle.com/javase/8/docs/api/java/security/SecureRandom.html)을 이용하자.
- 다른 주제이긴 하지만, 성능상의 이유로 매번 Random인스턴스를 생성하지 말아라. Seed업데이트만으로 충분하다.

#### Detail

* [ThreadLocalRandom](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/concurrent/ThreadLocalRandom.html#nextInt(int,int))
	* 배경 :
		* 멀티쓰레딩환경에서 랜덤값 생성 향상을 위해 JDK7에 추가.
		* ThreadLocal와 Random 클래스를 조합하여, 난수생성을 현재 쓰레드로 격리할수 있다.
			* ThreadLocalRandom.current().nextX(…) 형식으로 이용필요.
		* 따라서 Random 인스턴스에 대한 동시 액세스를 피함으로써, 다중 스레드 환경에서 더 나은 성능을 달성가능.
	* 장점: 
		* 더 나은 성능. 다중 스레드 환경에서 RandomClass보다, 더 나은 성능 제공.
		* 난수 스레드마다 격리 가능.한 스레드에서 얻은 난수는 다른 스레드의 영향을 받지 않는다.
		* Singleton이기에, 인스턴스 초기화 필요 없다. RandomClass 처럼 인스턴스를 명시적으로 초기화할 필요가 없다.
		* 따라서, This helps us to avoid mistakes of creating lots of useless instances and wasting garbage collector time.
	* 단점:
		* 시드를 명시적으로 설정하는 방법이 없어 재현이 어렵다. 사실 단점이 아니지만.
* [Random](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Random.html#nextInt(int))
	* 장점: 
		* 시드를 명시적으로 설정하는 방법이 있어, 재현이 상대적으로 쉽다.
	* 단점:
		* 인스턴스를 명시적으로 초기화할 필요가 있다.
		* 멀티쓰레딩 환경에서의, 성능 저하
			* Why? 
				* 모든 스레드가 동일한 시드 인스턴스 변수를 공유하기에, 
				* 시드업데이트시 경합으로 인한 성능저하.
			* How? 
				* Lock이 없기에, 모든 스레드가 동시에 시드 업데이트 진행.
				* 한 스레드는 이기고 시드를 업데이트하게 되고, 나머지 스레드는 잃는다.
				* 잃은 스레드는  난수 생성 기회를 얻을 때 까지  재시도한다.
* Refer
	* https://docs.oracle.com/javase/8/docs/api/java/util/Random.html
	* https://www.baeldung.com/java-thread-local-random

### Q: IAE는 복구가능한 예외로 구분되나? 


