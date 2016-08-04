package Crawling;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class XMLTest {

	public static void main(String[] args) throws UnsupportedEncodingException, IOException {
		
		String appendMatch = null;
        Document doc;
        try {
            doc = Jsoup.connect(
                    "http://synd.cricbuzz.com/j2me/1.0/livematches.xml").get();
 
            // System.out.println("agn "+doc);
            for (Element e : doc.select("mchdata")) {
                for (Element e1 : e.select("match")) {
                    // System.out.println(e1.attr("mchDesc"));
                    // Example Ind vs Zim
                    String matchInfo = e1.attr("mchDesc").toString();
                    if (appendMatch != null) {
                        appendMatch = appendMatch + " \n" + matchInfo;
                    } else {
                        appendMatch = matchInfo;
                    }
 
                    for (Element e2 : e1.select("state")) {
                        String matchStatus = null;
                        if (e2.attr("mchState").toString()
                                .equalsIgnoreCase("complete")) {
                            // Starts on Jul 27 at 18:00 GMT
                            matchStatus = e2.attr("status");
                            if (matchInfo != null) {
                                appendMatch = appendMatch + " \n" + matchStatus;
                            }
                            // System.out.println(e2.attr("status"));
                        } else {
                            // India won by 58 runs
                            matchStatus = e2.attr("status");
                            if (matchStatus != null) {
                                appendMatch = appendMatch + " \n" + matchStatus;
                                // System.out.println(e2.attr("status"));
                            }
                        }
                    }
                }
 
            }
 
            System.out.println(appendMatch);
        } catch (IOException e3) {
            // TODO Auto-generated catch block
            e3.printStackTrace();
        }
    
	}

}
