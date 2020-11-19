package com.cat.mylibrary.helper

import org.junit.Test

import org.junit.Assert.*

class HelperLinkKtTest {

    @Test
    fun `getUrlFromText() pass valid url with text return url`() {
        val data = "this link for my channel https://www.youtube.com asdsadsad"

        val result = HelperLink.getUrlFromText(data)

        val expected = "https://www.youtube.com"
        assertEquals(expected, result)
    }


    @Test
    fun `getUrlFromText() pass invalid url with text return empty text`() {
        val data = "this link for my channel htps:/www.youtube.com asdsadsad"

        val result = HelperLink.getUrlFromText(data)

        val expected = ""
        assertEquals(expected, result)
    }


    @Test
    fun `getUrlFromText() pass valid url return empty url`() {
        val data = "http://www.youtube"

        val result = HelperLink.getUrlFromText(data)

        val expected = data
        assertEquals(expected, result)
    }

    @Test
    fun `getUrlFromText() pass two valid url return first url`() {
        val data = "http://www.youtube http://www.google.com"

        val result = HelperLink.getUrlFromText(data)

        val expected = "http://www.youtube"
        assertEquals(expected, result)
    }

}