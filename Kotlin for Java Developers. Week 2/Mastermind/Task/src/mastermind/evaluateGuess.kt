package mastermind

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {
    val rightPosition = getRightPosition(secret, guess)
    val wrongPosition = getWrongPosition(secret, guess)
    return Evaluation(rightPosition, wrongPosition)
}

fun getRightPosition(secret: String, guess: String): Int {
    var position = 0;

    if(secret.isNullOrEmpty())
    for(i in secret.indices){
        if(secret[i] == guess[i])
            position++
    }
    return position
}

fun getWrongPosition(secret: String, guess: String) : Int {
    var letters = 0
    var newSecret = ""
    var newGuess = ""

    for(i in secret.indices){
        if (secret[i] != guess[i]){
            newSecret += secret[i]
            newGuess += guess[i]
        }
    }

    val evaluatedCharacters = mutableListOf<Char>()
    if(newSecret.isNotEmpty()){
        for (i in guess.indices){
            var letter = guess[i]
            if(!evaluatedCharacters.contains(letter)){
                val countSecret = countWrongPositions(newSecret , letter)
                val countGuess = countWrongPositions(newGuess , letter)
                letters += if (countSecret == countGuess || countSecret > countGuess) countGuess else countSecret
            }
            evaluatedCharacters.add(letter)
        }
    }
    return letters
}

fun countWrongPositions(letters: String, letter: Char): Int {
    var count = 0;
    for (i in letters.indices){
        if (letters[i] == letter)
            count++
    }
    return count
}
