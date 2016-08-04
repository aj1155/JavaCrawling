package Crawling;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class XMLNews {

	public static void main(String[] args) throws IOException {
		String appendMatch = null;
		String title = new String();
		String html = new String();
        Document doc;
        doc = Jsoup.connect(
                "http://rss.hankyung.com/new/news_sports.xml").get();

        // System.out.println("agn "+doc);
        for (Element e : doc.select("item")) {
        	
        
        	for(Element k: e.select("title"))
        	{
        		title = k.text();
        		System.out.println("제목: "+title);
        	}
        	for(Element k:e.select("link"))
        	{
        		System.out.println("링크: "+k.text());
        	}
        	for(Element k:e.select("description"))
        	{
        		System.out.println("중략: "+k.text()+"..");
        	}
        	for(Element k:e.select("pubDate"))
        	{
        		System.out.println("수정날짜: "+k.text());
        	}
        	
        	System.out.println();
        	
        
        	
        }

	}

}
