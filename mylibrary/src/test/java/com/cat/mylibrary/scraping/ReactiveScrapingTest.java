package com.cat.mylibrary.scraping;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.filters.SmallTest;

import com.cat.mylibrary.models.LinkInfo;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

public class ReactiveScrapingTest {

    @Test
    public void getLinkInfo() {
        LinkInfo linkInfo = ReactiveScraping.getLinkInfo("http://www.jsonschema2pojo.org/");

        System.out.println(linkInfo.getTitle());
        System.out.println(linkInfo.getDescription());
        System.out.println(linkInfo.getImageUrl());

        String expected = "jsonschema2pojo";
        assertEquals(expected, linkInfo.getTitle());
    }
}