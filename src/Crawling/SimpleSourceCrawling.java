package Crawling;
//������ �ҽ��ڵ带 ������
import java.net.*;
import java.io.*;

public class SimpleSourceCrawling {

	public static void main(String[] args) {
		try{
			//example.com�� �������� ����ϱ� ���� �������̴�. ������ �������� �ҽ��ڵ��� �絵 ����.
			String urlstr = "http://www.skhu.ac.kr";
			//URL ���ڿ��� ó���ϱ� ���� URLŬ������ �̿��Ѵ�.
			URL url = new URL(urlstr);
			//�ҽ��ڵ带 �������� ���� ��Ʈ���� �����Ѵ�
			BufferedReader bf;
			String line;
			//URLŬ������ openStream()�Լ��� ������ ���ּ��� �ҽ��ڵ带 �޾ƿ� �� �ִ�.
			bf = new BufferedReader(new InputStreamReader(url.openStream()));
			
			while((line=bf.readLine())!=null){
				System.out.println(line);
			}
			//��Ʈ���� �ݾ��ش�.
			bf.close();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}

	}

}
