package com.cat.mylibrary.scraping;

import com.cat.mylibrary.models.LinkInfo;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.List;

/**
 * this class is used only to scrap the link and return the result
 *
 * @createdBy ahmed_shehata
 */
public class ReactiveScraping {

    public static LinkInfo getLinkInfo(String url) {
        // TODO setup jsoup object then pass the link to it and return the result

        Document document = null;
        LinkInfo linkInfo = null;
        try {

            document = getDocument(url);
            String title = document.title();
            String description = getDescription(document);

            String imageUrl = document.select("img").first().absUrl("src");
            linkInfo = new LinkInfo(title, description, imageUrl, url);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return linkInfo;
    }

    private static String getDescription(Document document) {
        List<Element> elements = document.getElementsByTag("meta");
        for (Element element :
                elements) {
            if (element.attr("name").equals("description")) {
                return element.attr("content");
            }
        }
        return "";
    }

    private static Document getDocument(String url) throws IOException {
        return Jsoup.connect(url).get();
    }
}
