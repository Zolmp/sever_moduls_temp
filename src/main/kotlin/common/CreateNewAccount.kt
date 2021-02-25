package common


import org.json.JSONObject
import settings.Generator
import ru.talenttech.xqa.oknetwork.OkNetwork
import java.text.SimpleDateFormat
import java.util.*


class CreateNewAccount {

 val generator = Generator()
    


        fun createNewProfile(token: String) : String{
            val random = Random().nextInt(1000);
            val SIBUR = "pupkonovich$random@sever.ai"
            val pass = "password"
            val sdf = SimpleDateFormat("dd/M/yyyy hh:mm")
            val datanow = sdf.format(Date())
            val companyTitle = generator.generatorCompanyNames().toString()
            val firstName = generator.generatorFirstNamesMale()
            val lastName = generator.generatorLastNamesMale()
            val midleName = generator.generatorMiddleNamesMale()

            val jo = JSONObject().apply {
                put("voxImplantCallRule", "1241769")
                put("cvScoringModel", "UNICV")
                put("videoScoringModelUrl", true)
                put("flow", "SIBUR")
                put("companyName", "XQA")
                put("companyTitle", companyTitle + datanow)
                put("companyDescription", "Hacked everyThing!")
                put("username", SIBUR)
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
            return SIBUR
        }
    }