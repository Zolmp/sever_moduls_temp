package kotlin
import java.nio.file.Files
import java.nio.file.Paths
import java.util.*

class settings {


    fun string(): String? {
        val symbols = "QwErTy012345"
        val randString = StringBuilder()
        val count = (Math.random() + 7).toInt()
        for (i in 0 until count) {
            randString.append(symbols[(Math.random() * symbols.length).toInt()])
        }
        return randString.toString()
    }

    fun stringvac(): String? {
        val symbols = "dufoaTy0123456789"
        val randString = StringBuilder()
        val count = (Math.random() + 3).toInt()
        for (i in 0 until count) {
            randString.append(symbols[(Math.random() * symbols.length).toInt()])
        }
        return randString.toString()
    }

    fun generatorVacancies(): String? {
        var result = "" + stringvac()
        val vacancyNames = "src/test/resources/vacanciesNames.txt"
        val r = Random()
        try {
            val vacancyName: Array<Any> =
                Files.readAllLines(Paths.get(vacancyNames)).toTypedArray()
            result = vacancyName[r.nextInt(vacancyName.size)].toString()
        } catch (e: java.lang.Exception) {
        }
        return result + stringvac()
    }

    fun generatorFirstNamesFemale(): String {
        var result = ""
        val firstNames = "src/test/resources/femaleNames.txt"
        val r = Random()
        try {
            val firstName = Files.readAllLines(Paths.get(firstNames)).toTypedArray()
            result = firstName[r.nextInt(firstName.size)].toString()
        } catch (e: Exception) {
        }

        return result
    }

    fun generatorFirstNamesMale(): String {
        var result = ""
        val firstNames = "src/test/resources/maleNames.txt"
        val r = Random()
        try {
            val firstName = Files.readAllLines(Paths.get(firstNames)).toTypedArray()
            result = firstName[r.nextInt(firstName.size)].toString()
        } catch (e: Exception) {
        }

        return result
    }

    fun generatorLastNamesFemale(): String {
        var result = "" + "а"
        val firstNames = "src/test/resources/maleLastNames.txt"
        val r = Random()
        try {
            val firstName = Files.readAllLines(Paths.get(firstNames)).toTypedArray()
            result = firstName[r.nextInt(firstName.size)].toString()
        } catch (e: Exception) {
        }

        return result + "а"
    }

    fun generatorLastNamesMale(): String {
        var result = ""
        val firstNames = "src/test/resources/maleLastNames.txt"
        val r = Random()
        try {
            val firstName = Files.readAllLines(Paths.get(firstNames)).toTypedArray()
            result = firstName[r.nextInt(firstName.size)].toString()
        } catch (e: Exception) {
        }

        return result
    }

    fun generatorMiddleNamesFemale(): String {
        var result = "" + "овна"
        val firstNames = "src/test/resources/maleNames.txt"
        val r = Random()
        try {
            val firstName = Files.readAllLines(Paths.get(firstNames)).toTypedArray()
            result = firstName[r.nextInt(firstName.size)].toString()
        } catch (e: Exception) {
        }

        return result + "овна"
    }

    fun generatorMiddleNamesMale(): String {
        var result = "" + "ович"
        val firstNames = "src/test/resources/maleNames.txt"
        val r = Random()
        try {
            val firstName = Files.readAllLines(Paths.get(firstNames)).toTypedArray()
            result = firstName[r.nextInt(firstName.size)].toString()
        } catch (e: Exception) {
        }

        return result + "ович"
    }

    fun generatorCompanyNames(): String {
        var result = ""
        val firstNames = "src/test/resources/companyNames.txt"
        val r = Random()
        try {
            val firstName = Files.readAllLines(Paths.get(firstNames)).toTypedArray()
            result = firstName[r.nextInt(firstName.size)].toString()
        } catch (e: Exception) {
        }

        return result
    }
}