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

public class JsoupParsing {

	public static void main(String[] args) {
		HttpClient httpClient = new DefaultHttpClient();
	    HttpGet httpget = new HttpGet("http://sports.news.naver.com/kbaseball/record/index.nhn");
	    try {
	      httpClient.execute(httpget, new BasicResponseHandler() {
	        @Override
	        public String handleResponse(HttpResponse response) throws HttpResponseException,
	            IOException {
	          // ���������� �׳� ������� �ѱ��� ������. ���ڵ� ó���� �ؾ��ؿ�.
	          String res = new String(super.handleResponse(response).getBytes("8859_1"), "euc-kr");
	          Document doc = Jsoup.parse(res);
	          Elements rows = doc.select("div.tbl_box table tbody tr");
	          String[] items = new String[] { "����", "��", "����", "��", "��", "��", "�·�","������", "����",
	           "�����","��Ÿ��","�ֱ� 10���" };
	          for (Element row : rows) {
	        	Iterator<Element> iter = row.getElementsByTag("th").iterator();
	            Iterator<Element> iterElem = row.getElementsByTag("td").iterator();
	            StringBuilder builder = new StringBuilder();
	            for (String item : items) {
	              if(item.equals("����"))
	              {
	            	  builder.append(item + ": " + iter.next().text() + "   \t");
	              }
	              else{
	            	  builder.append(item + ": " + iterElem.next().text() + "   \t");
	              }
	              
	            }
	            System.out.println(builder.toString());
	          }
	 
	          return res;
	        }
	      });
	    } catch (ClientProtocolException e) {
	      e.printStackTrace();
	    } catch (IOException e) {
	      e.printStackTrace();
	    }

	}

}
