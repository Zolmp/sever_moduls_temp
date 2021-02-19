package accounts
import org.json.JSONObject
import ru.talenttech.xqa.oknetwork.OkNetwork
import ru.talenttech.xqa.oknetwork.OkNetwork.restClient
import java.lang.String.format
import java.util.*




class CreateSibur {

    private val temp = sever_repository.getInstance()

    fun createNewProfile(token: String) : String{
        val random = Random().nextInt(1000);
        val login = "pupkonovich$random@sever.ai"
        val pass = "password"
        val companyTitle = settings.generatorCompanyNames()
        val firstName = settings.generatorFirstNamesMale()
        val lastName = settings.generatorLastNamesMale()
        val midleName = settings.generatorMiddleNamesMale()
        val jo = JSONObject().apply {
            put("voxImplantCallRule", "1241769")
            put("cvScoringModel", "UNICV")
            put("videoScoringModelUrl", true)
            put("flow", "SIBUR")
            put("companyName", "XQA")
            put("companyTitle", companyTitle + datanow)
            put("companyDescription", "Hacked everyThing!")
            put("username", login)
            put("password", pass)
            put("firstName", firstName)
            put("lastName", lastName)
            put("middleName", midleName)
            put("email", "test.sever.ai+$random@gmail.com")
            put("locale", "ru")
        }
        val vacancy = OkNetwork.restClient().post(
                url = "https://develop.north.ai/admin/demo",
                headers = mutableMapOf(
                        "Content-Type" to "application/json",
                        "Authorization" to "Bearer $token"
                ),
                body = jo.toString()
        )
        return login
    }
}