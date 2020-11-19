package com.cat.mylibrary.helper

class HelperLink {

    companion object {

        @JvmStatic
        fun getUrlFromText(data: String): String? {
            val link = StringBuilder()
            val protocol = getProtocol(data)
            if (protocol != "") {
                val index = data.indexOf(protocol)
                for (i in index until data.length) {
                    if (data[i] == ' ') break
                    link.append(data[i])
                }
            }
            return link.toString()
        }

        @JvmStatic
        private fun getProtocol(text: String): String {
            return if (text.contains("https://")) "https://" else if (text.contains("http://")) "http://" else ""
        }
    }
}