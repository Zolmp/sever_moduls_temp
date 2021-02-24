package settings

class Repository {


    private val instance: Repository = Repository()
    private fun repository() {}
    fun getInstance(): Repository? {
        return instance
    }

    private var SIBUR: String? = null
    private var login: String? = null
    private var recruiterToken: String? = null
    private var kaToken: String? = null
    private var draftId: Int = 0
    private var draftCvsIdRR: Int = 0
    private var draftCandidateIdRR: Int = 0
    private var vakancyPublikationsID: Int = 0


    fun getSIBUR(): String? {
        return SIBUR
    }

    fun setSIBUR(SIBUR: String) {
        this.SIBUR = SIBUR
    }

    fun getAdminToken(): String {
        return adminToken
    }

    fun setAdminToken(adminToken: String) {
        this.adminToken = adminToken
    }

    fun getstrelchenkoToken(): String {
        return strelchenkoToken
    }

    fun setstrelchenkoToken(strelchenkoToken: String) {
        this.strelchenkoToken = strelchenkoToken
    }

}