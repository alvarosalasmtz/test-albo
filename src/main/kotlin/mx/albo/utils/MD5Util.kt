package mx.albo.utils

import java.security.MessageDigest
import javax.xml.bind.DatatypeConverter


class MD5Util {
    companion object {
        fun generate(data: String): String {
            val md: MessageDigest = MessageDigest.getInstance("MD5")
            md.update(data.toByteArray())
            return DatatypeConverter.printHexBinary(md.digest()).lowercase()
        }
    }
}