package Crawling;

import java.io.IOException;
import java.util.Iterator;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class NaverSearching {

	public static void main(String[] args) throws IOException
	{
		
		Document document = Jsoup.connect("http://www.naver.com").get();
        
        if (null != document) {
            // id가 realrank 인 ol 태그 아래 id가 lastrank인 li 태그를 제외한 모든 li 안에 존재하는
            // a 태그의 내용을 가져옵니다.
            Elements elements = document.select("ol#realrank > li:not(#lastrank) > a");
             
            for (int i = 0; i < elements.size(); i++) {
                System.out.println("------------------------------------------");
                System.out.println("검색어 : " + elements.get(i).attr("title"));
                System.out.println("랭킹 : " + (i + 1));
                System.out.println("상승여부 : " + elements.get(i).select("span.tx").text());
                System.out.println("상승단계 : " + elements.get(i).select("span.rk").text());
                System.out.println("링크 URL : " + elements.get(i).attr("href"));
                System.out.println("------------------------------------------");
            }
        }

		
	}
	

}
