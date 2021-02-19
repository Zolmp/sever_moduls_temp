package kotlin

class sever_repository {

    private val instance = sever_repository()
    private fun sever_repository() {}
    fun getInstance() {
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


    fun getlogin(): String? {
        return login
    }

    fun setlogin(login: String) {
        this.login = login
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