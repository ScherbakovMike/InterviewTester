package ru.mikescherbakov.interviewtester.models;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class HTMLHelper {
    private static final Logger logger = LoggerFactory.getLogger(HTMLHelper.class);
    private static final String catalogURL = "https://github.com/enhorse/java-interview#%D0%92%D0%BE%D0%BF%D1%80%D0%BE%D1%81%D1%8B-%D0%B4%D0%BB%D1%8F-%D1%81%D0%BE%D0%B1%D0%B5%D1%81%D0%B5%D0%B4%D0%BE%D0%B2%D0%B0%D0%BD%D0%B8%D1%8F-%D0%BD%D0%B0-java-developer";
    public static boolean updateCatalog() {
        try {
            Document doc = Jsoup.connect(catalogURL)
                    .userAgent("Chrome/4.0.249.0 Safari/532.5")
                    .referrer("http://www.google.com")
                    .get();
            Elements elements = doc.select("#readme > div.Box-body.px-5.pb-5 > article > ul:nth-child(3)");
            for(Element el:elements) {
                for(Element href:el.getElementsByAttribute("href")) {
                    String url = href.attr("href");
                    String title = href.text();
                    if(url.startsWith("#")){

                    }
                }
            }
            return true;
        } catch (IOException e) {
            logger.error("Document doc = Jsoup.connect(catalogURL).get()", e);
        }
        return false;
    }
}
