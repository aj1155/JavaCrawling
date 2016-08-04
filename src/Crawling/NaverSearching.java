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
            // id�� realrank �� ol �±� �Ʒ� id�� lastrank�� li �±׸� ������ ��� li �ȿ� �����ϴ�
            // a �±��� ������ �����ɴϴ�.
            Elements elements = document.select("ol#realrank > li:not(#lastrank) > a");
             
            for (int i = 0; i < elements.size(); i++) {
                System.out.println("------------------------------------------");
                System.out.println("�˻��� : " + elements.get(i).attr("title"));
                System.out.println("��ŷ : " + (i + 1));
                System.out.println("��¿��� : " + elements.get(i).select("span.tx").text());
                System.out.println("��´ܰ� : " + elements.get(i).select("span.rk").text());
                System.out.println("��ũ URL : " + elements.get(i).attr("href"));
                System.out.println("------------------------------------------");
            }
        }

		
	}
	

}
