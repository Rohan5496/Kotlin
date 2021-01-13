class Person(val name: String, val age: Int) {

    fun isOlder(ageLimit: Int) = age > ageLimit

    fun getAgePredicate() = ::isOlder
}

fun main() {
    var s = "abc"
    println(s.zipWithNext())
    val ppl = Person("Rohan", 24)
    val agePredicate = ppl::isOlder
    println(agePredicate(25))

    val agePred2 = ppl.getAgePredicate()
    println(agePred2(18))

    println(duplicateNonZero(listOf(2,0,5)))

    println(duplicateNonZeroAndReturnFromLambda(listOf(2,0,5)))

    println(duplicateNonZeroLocalFunction(listOf(1,2,3,0)))

    println(duplicateNonZeroUsingAnonymousFunction(listOf(1,2,3,0)))


}


