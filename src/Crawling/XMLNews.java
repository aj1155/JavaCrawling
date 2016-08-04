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
        		System.out.println("����: "+title);
        	}
        	for(Element k:e.select("link"))
        	{
        		System.out.println("��ũ: "+k.text());
        	}
        	for(Element k:e.select("description"))
        	{
        		System.out.println("�߷�: "+k.text()+"..");
        	}
        	for(Element k:e.select("pubDate"))
        	{
        		System.out.println("������¥: "+k.text());
        	}
        	
        	System.out.println();
        	
        
        	
        }

	}

}
