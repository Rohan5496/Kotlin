import Gender.*

fun main() {
    val heroes = listOf(
        Hero("The Captain", 60, MALE),
        Hero("Frenchy", 42, MALE),
        Hero("The Kid", 9, null),
        Hero("Lady Lauren", 29, FEMALE),
        Hero("First Mate", 29, MALE),
        Hero("Sir Stephen", 37, MALE)
    )

    // Sir Stephen
    println(heroes.last().name)

    // null
    println(heroes.firstOrNull { it.age == 30 }?.name)

    // 5
    println(heroes.map { it.age }.distinct().size)

    //3
    println(heroes.filter { it.age > 30 }.size)

    val (youngest, oldest) = heroes.partition { it.age < 30 }

    println("Youngest list size :  ${youngest.size} \nOldest List Size : ${oldest.size}")

    // The Captain
    println(heroes.maxByOrNull { it.age }?.name)

    // The Kid
    println(heroes.minByOrNull { it.age }?.name)

    // false
    println(heroes.all { it.age == 50 }) //checks for the given condition is satisfied by all the elements of the list

    //true
    println(heroes.any { it.gender == FEMALE }) // check if any element satisfies the given condition

    // Using GroupBy
    val mapByAge: Map<Int, List<Hero>> = heroes.groupBy { it.age }

    val (age, group) = mapByAge.maxByOrNull { (_, group) -> group.size }!!

    println(age)

    // Using AssociateBy
    val mapByName: Map<String, Hero> = heroes.associateBy { it.name }

    println(mapByName.getValue("Frenchy").age)
    // OR
    println(mapByName["Frenchy"]?.age)

    // Using Associate
    val mapByName2 = heroes.associate { it.name to it.age }
    println(mapByName2.getOrElse("The Kid") { 0 })

    val flatMap = heroes.flatMap { heroes.map { hero -> it to hero } }
    // OR
    val allPossibleVariations = heroes.flatMap {
            first -> heroes.map { second -> first to second } }

    val isEven = {i:Int -> i%2 == 0}

    fun isEven(i:Int) : Boolean = i%2 == 0

    val list = listOf(1,2,3,4)

    println(list.any(::isEven))
    println(list.any(isEven))

    println(list.filter(isEven))

}

fun duplicateNonZero(list: List<Int>) : List<Int> {
    return list.flatMap {
        if (it == 0) return listOf()
        listOf(it,it)
    }
}

fun duplicateNonZeroAndReturnFromLambda(list: List<Int>) : List<Int> {
    return list.flatMap {
        if (it == 0) return@flatMap listOf()
        listOf(it,it)
    }
}

fun duplicateNonZeroLocalFunction(list:List<Int>) : List<Int> {
    fun duplicateNonZeroElement(e : Int) : List<Int> {
        if (e == 0) return listOf()
        return listOf(e,e)
    }
    return list.flatMap(::duplicateNonZeroElement)
}

fun duplicateNonZeroUsingAnonymousFunction(list: List<Int>) : List<Int> {
    return list.flatMap(fun (e) : List<Int>{
        if (e ==0) return listOf()
        else
            return listOf(e,e)
    })
}

