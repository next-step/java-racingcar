## 조언주신 규칙 적용할것들
- [규칙 1: 메서드당 들여쓰기 한번](https://developerfarm.wordpress.com/2012/01/26/object_calisthenics_2/)

- 랜덤 메서드를 매번 뽑는것 보다 인스턴스를 만들어서 nextInt를 사용하자
```java
    public static int generateRandomNumber() {
        return new Random().nextInt(BOUND_CONDITION);
    }
```


#### 리팩토링 요구사항
- 핵심 비즈니스 로직을 가지는 객체를 domain 패키지 , UI 관련한 객체를 view 패키지에 구현한다.(완료)
- MVC 패턴 기반으로 리팩토링해 view 패키지의 객체가 domain 패키지 객체에 의존할수 있다.(완료)
- domain패키지의 객체는 view패키지 객체에 의존하지 않도록 구현한다.(완료)
- 테스트 가능한 부분과 테스트하기 힘든 부분을 분리해 테스트 가능한 부분에 대해서만 단위테스트 한다(완료)
