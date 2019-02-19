package io.mavenchu.Scraping;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class TestBdJobs {
	private static WebClient webClient = null;
	String Url = "https://bikroy.com/bn/ad/4ji-6ji-oyyelddaar-gcc-kaataar-dhaka";
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() throws MalformedURLException, IOException {
		try {
			WebClient webClient = new WebClient();
			webClient.getOptions().setJavaScriptEnabled(false); 
			HtmlPage page1 = webClient.getPage(Url);
			webClient.getOptions().setJavaScriptEnabled(false); 
			System.out.println(page1.getTitleText());
			String baseUrl = Url.substring(0, 19);
			System.out.println("BaseUrl: "+baseUrl);
			
			webClient.waitForBackgroundJavaScript(50 * 1000);
				
			
			HtmlElement jobListE = (HtmlElement) page1.getBody().getByXPath("//span@[class='col-6 t-left']").get(0);
			System.out.println(jobListE.getTextContent());
			
		
//			String loc = list.get(i).getElementsByTagName("td").get(2).getTextContent().trim();
//			String jn = list.get(i).getElementsByTagName("td").get(1).getTextContent().trim();

//			System.out.println("Job loc: "+loc);
//			System.out.println("Job Name: "+jn);
			System.out.println();
//		}
			} catch (FailingHttpStatusCodeException e) {
				System.out.println(" failed to connect site");
			}
	}

}
