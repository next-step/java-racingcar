// 자동차 구조체 정의
data class Car(val name: String, var position: Int = 0)

fun main() {

    // 자동차 이름 입력받기
    val cars = inputCarNames()
}

fun inputCarNames(): List<Car> {
    print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n")
    val carNames = readLine()?.split(",") ?: throw IllegalArgumentException("자동차 이름을 입력해야 합니다.")
    return carNames.map { name -> Car(name.trim()) }
}
