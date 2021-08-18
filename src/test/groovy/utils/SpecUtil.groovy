package utils

import org.apache.commons.lang3.RandomStringUtils

class SpecUtil {

    static def getRandomString() {
        def charset = (('A'..'Z') + ('0'..'9')).join()
        def length = 20
        return RandomStringUtils.random(length, charset.toCharArray())
    }
}