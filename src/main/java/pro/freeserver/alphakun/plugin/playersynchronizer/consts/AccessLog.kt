package pro.freeserver.alphakun.plugin.playersynchronizer.consts

import java.net.InetAddress
import java.time.LocalDateTime
import java.util.*

class AccessLog constructor(fs_user: UUID, time_stamp: LocalDateTime, ip_addr: InetAddress){
    val fs_user: UUID
    val issued_at: String
    val ip: String

    init {
        this.fs_user = fs_user
        this.issued_at = time_stamp.toString()
        this.ip = ip_addr.hostAddress
    }
}