package Crawling;
//페이지 소스코드를 가져옴
import java.net.*;
import java.io.*;

public class SimpleSourceCrawling {

	public static void main(String[] args) {
		try{
			//example.com은 연습으로 사용하기 위한 페이지이다. 간단한 페이지로 소스코드의 양도 적다.
			String urlstr = "http://www.skhu.ac.kr";
			//URL 문자열을 처리하기 위해 URL클래스를 이용한다.
			URL url = new URL(urlstr);
			//소스코드를 가져오기 위한 스트림을 선언한다
			BufferedReader bf;
			String line;
			//URL클래스의 openStream()함수로 지정한 웹주소의 소스코드를 받아올 수 있다.
			bf = new BufferedReader(new InputStreamReader(url.openStream()));
			
			while((line=bf.readLine())!=null){
				System.out.println(line);
			}
			//스트림을 닫아준다.
			bf.close();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}

	}

}
