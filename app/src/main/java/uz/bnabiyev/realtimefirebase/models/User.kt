package uz.bnabiyev.realtimefirebase.models

class User {
    var displayName: String? = null
    var uid: String? = null
    var email: String? = null
    var photoUrl: String? = null

    constructor(displayName: String?, uid: String?, email: String?, photoUrl: String?) {
        this.displayName = displayName
        this.uid = uid
        this.email = email
        this.photoUrl = photoUrl
    }

    constructor()

    override fun toString(): String {
        return "User(displayName=$displayName, uid=$uid, email=$email, photoUrl=$photoUrl)"
    }


}
