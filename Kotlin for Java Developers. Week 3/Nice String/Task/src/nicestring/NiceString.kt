package nicestring

fun String.isNice(): Boolean {
    return listOf(doesNotContainPredefinedString(this),
        containsAtLeast3Vowel(this),
        containsDoubleLetters(this)
    ).count {it} >=2

    (0 until this.lastIndex).any { this[it] == this[it++] }
}

fun containsDoubleLetters(s: String): Boolean {
    for(i in 0 until s.lastIndex){
        if (s[i] == s[i+1])
            return true
    }
    return false
}

fun containsAtLeast3Vowel(s: String): Boolean {
    return s.count { it.equals('a') || it.equals('e')
                    || it.equals('i') || it.equals('o') || it.equals('u') } >= 3
}

fun doesNotContainPredefinedString(s: String): Boolean {
    val containPredefinedStrings = !(s.contains("bu", true)
            || s.contains("ba", true)
            || s.contains("be", true))

    return containPredefinedStrings
}


