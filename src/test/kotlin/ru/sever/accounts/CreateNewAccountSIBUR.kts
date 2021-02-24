package kotlin.accounts

import common.CreateNewAccount
import org.json.JSONObject
import org.junit.Test
import ru.sever.scenarios.createNewProfile
import ru.talenttech.xqa.oknetwork.OkNetwork
import java.util.*


class CreateSibur {
    @Test
    fun CreateBasicEntity() {

        val newProfile = CreateNewAccount()
        newProfile.createNewProfile()
    }


}