package scenarios
import junit.framework.Assert.assertTrue
import org.json.JSONArray
import java.util.*
import org.json.JSONObject
import org.junit.Before
import org.junit.Test
import ru.talenttech.xqa.oknetwork.OkNetwork
import ru.talenttech.xqa.oknetwork.OkNetwork.restClient
import ru.talenttech.xqa.oknetwork.actions.Condition
import ru.talenttech.xqa.oknetwork.actions.shouldBe
import java.lang.String.format
import java.text.SimpleDateFormat

class ExampleTest {


    @Test
    fun execute() {
        val jo0 = JSONObject().apply {
            put("username", "admin@sever.ai")
            put("password", "J\$ngl1Bells");
        }
        val token = getAutorizeToken(jo0)
        val login = createNewProfile(token);
        val jo1 = JSONObject().apply {
            put("username", login)
            put("password", "password")
        }
        val clientToken = getAutorizeToken(jo1)
        val vacancyID = createNewVacancy(clientToken);
        val candidateID = createCandidate(clientToken, vacancyID)
        val statusCandidate = checkCandididateStatus(clientToken, candidateID)
        System.out.println(">>>>" + statusCandidate);
        val inviteCandidate = inviteCandidate(token, candidateID)
        assertTrue("Кандидат не приглашен.", inviteCandidate.equals("INVITE"))
        val inviteToVideointerview = inviteToVideointerview(token, candidateID)
        assertTrue("Кандидат не приглашен на видеоинтервью.", inviteToVideointerview.equals("inviteToVideointerview"))
        val scheduleMeeting = scheduleMeeting(token, candidateID)
        val hireCandidate = hireCandidate(token, candidateID)

    }
}
fun getAutorizeToken(json : JSONObject) : String{
    val result = OkNetwork.restClient().post(
            url = "https://develop.north.ai/login",
            headers = mutableMapOf(
                    "Content-Type" to "application/json",
            ),
            body = json.toString()
    ).headers
    val token = result["authorization"].toString().replace("[", "").replace("]", "");
    return token
}
fun createNewProfile(token: String) : String{
    val random = Random().nextInt(1000);
    val login = "pupkonovich$random@sever.ai"
    val pass = "password"
    val jo = JSONObject().apply {
        put("voxImplantCallRule", "1241769")
        put("cvScoringModel", "UNICV")
        put("videoScoringModelUrl", true)
        put("companyName", "XQA")
        put("companyTitle", "CompanyTitle for XQA")
        put("companyDescription", "Hacked everyThing!")
        put("username", login)
        put("password", pass)
        put("firstName", "Иван")
        put("lastName", "Пупкин")
        put("middleName", "Иванович")
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
fun createNewVacancy(token: String) : String {
    val educationType = JSONObject().apply {
        put("name", "HIGHER")
    }
    val city = JSONObject().apply {
        put("id", "887")
    }
    val language = JSONObject().apply {
        put("id", "74")
    }
    val industry = JSONObject().apply {
        put("id", "216")
    }
    val sex = JSONObject().apply {
        put("name", "MALE")
    }
    val languageLevel = JSONObject().apply {
        put("name", "FLUENT")
    }
    val workType = JSONObject().apply {
        put("name", "FULL_TIME")
    }
    val scheduleType = JSONObject().apply {
        put("name", "SCHEDULE_5_2")
    }
    val citizenship = JSONObject().apply {
        put("id", "2")
    }
    val specialization = JSONObject().apply {
        put("id", "341")
    }
    val experienceTypes =  JSONArray()
            .put(
                    JSONObject()
                            .put("experienceType", JSONObject().put("name", "BETWEEN_1_AND_3_YEARS"))
            )
            .put(
                    JSONObject()
                            .put("experienceType", JSONObject().put("name", "BETWEEN_3_AND_6_YEARS"))
            )
    val vacancyjo1 = JSONObject().apply {
        put("title", "(Открытие) Специалист по административной поддержке")
        put("publicationTitle", "(Открытие) Специалист по административной поддержке")
        put("salaryGrossFrom", "20000")
        put("salaryGrossTo", "100000")
        put("ageFrom", "18")
        put("ageTo", "60")
        put("businessTrip", "true")
        put("relocation", "true")
        put("educationType", educationType)
        put("sex", sex)
        put("language", language)
        put("languageLevel", languageLevel)
        put("experienceTypes", experienceTypes)
        put("workType", workType)
        put("scheduleType", scheduleType)
        put("city", city)
        put("citizenship", citizenship)
        put("industry", industry)
        put("specialization", specialization)
        put("description", "Специалист по административной поддержке")
        put("requirements", "•\tВысшее образование;\n•\tОпыт работы секретарем-референтом или личным помощником в  крупной российской компании не менее 1,5 лет;\n•\tОпыт организации командировок;\n•\tОпыт работы в электронных системах документооборота;\n•\tОпыт протоколирования встреч;\n•\tЗнание основ этикета, бизнес-лексики;\n•\tИсполнительность, стрессоустойчивость, ответственность, инициативность, многозадачность.\n•\tЗнания ПК:  Уверенный пользователь пакета программ MS Office (Outlook  (почта, календарь, контакты), Word, Excel, PowerPoint")
        put("responsibilities", "•\tАдминистративная поддержка нескольких руководителей;\n•\tПланирование рабочего дня руководителей;\n•\tВедение деловой переписки и электронного документооборота;\n•\tПоиск, обработка, анализ информации по различным темам, связанным с бизнесом подразделения;\n•\tОрганизация встреч и командировок (бронирование гостиниц, визы, билеты")
        put("additionalTerms", "•\tЗаработная плата по результатам собеседования;\n•\tПремии по результатам работы;\n•\tДобровольное медицинское страхование;\n•\tОформление по ТК РФ;\n•\tСпорт и социальная программа для сотрудников и их детей")
        put("keywords", "Секретарь-референт, Административная поддержка руководителей")
        put("stopPhrase", "ПАО Банк ФК Открытие")
        put("searchHh", "true")
        put("searchSuperJob", "false")
        put("searchAvito", "false")
        put("searchWorkua", "false")
    }
    val vacancynew: Integer = restClient().put(
            url = "https://develop.north.ai/api/vacancies",
            headers = mutableMapOf(
                    "Content-Type" to "application/json",
                    "Authorization" to "Bearer $token"
            ),
            body = vacancyjo1.toString()
    ).body("id")

    return vacancynew.toString()
}
fun createCandidate(token: String, vacancyID: String): Integer {
    val random = Random().nextInt(1000)
    val candidateJo = JSONObject().apply {
        put("firstName", "Имя")
        put("lastName", "Фамилия")
        put("email", "test.sever.ai+$random@gmail.com")
        put("phone", "+79851525532")
        put("title", "Менеждер")
    }
    val candidate = OkNetwork.restClient().post(
            url = "https://develop.north.ai/api/candidates/vacancy/$vacancyID",
            headers = mutableMapOf(
                    "Content-Type" to "application/json",
                    "Authorization" to "Bearer $token"
            ),
            body = candidateJo.toString()
    )
    System.out.println("candidateID =" + candidate)
    return candidate.body("id")

}

 fun checkCandididateStatus(token: String, candidateID: Integer): String {
     val candidate = OkNetwork.restClient().get(
     url = "https://develop.north.ai/api/candidates/$candidateID",
     headers = mutableMapOf(
             "Content-Type" to "application/json",
             "Authorization" to "Bearer $token" )
     )
     System.out.println("statusCandidate =" + candidate)
     return candidate.body("candidateStatus.name")
 }

fun inviteCandidate(token: String, candidateID: Integer): String {
    val candidate = OkNetwork.restClient().put(
            url = "https://develop.north.ai/api/candidates/$candidateID/invite",
            headers = mutableMapOf(
                    "Content-Type" to "application/json",
                    "Authorization" to "Bearer $token" ),
        body = ""

    )
    System.out.println("statusCandidate =" + candidate)
    return candidate.body("candidateStatus.name")
}

fun inviteToVideointerview(token: String, candidateID: Integer): String {
    val candidate = OkNetwork.restClient().put(
            url = "https://develop.north.ai/api/candidates/$candidateID/invite-to-videointerview",
            headers = mutableMapOf(
                    "Content-Type" to "application/json",
                    "Authorization" to "Bearer $token" )
    )
    System.out.println("statusCandidate =" + candidate)
    return candidate.body("candidateStatus.name")
}

//Назначение встречи
// проверить!!!
fun scheduleMeeting(token: String, candidateID: Integer): String {
    val date = Calendar.getInstance()
    date.add(Calendar.DATE, 7)
    val meetingDateTime = JSONObject().apply {
        put("meetingDateTime", date)
    }
    val location = JSONObject().apply {
        put("location", "Mars")
    }
    val candidate = OkNetwork.restClient().post(
            url = "https://develop.north.ai/api/candidates/$candidateID/schedule-meeting",
            headers = mutableMapOf(
                    "Content-Type" to "application/json",
                    "Authorization" to "Bearer $token" )
    )
    System.out.println("statusCandidate =" + candidate)
    return candidate.body("candidateStatus.name")
}

//Нанять
fun hireCandidate(token: String, candidateID: Integer): String {
    val candidate = OkNetwork.restClient().put(
            url = "https://develop.north.ai/api/candidates/$candidateID/change-status-to-hired",
            headers = mutableMapOf(
                    "Content-Type" to "application/json",
                    "Authorization" to "Bearer $token" )
    )
    System.out.println("statusCandidate =" + candidate)
    return candidate.body("candidateStatus.name")
}


//проверить ручки для отклонения и удаления кандидата в статусе нанят - 200 ок
//создать канд и отклонить, затем удалить
//созд канд и удалить
//удаление чужого кандидата при помощи своего токена - 404

