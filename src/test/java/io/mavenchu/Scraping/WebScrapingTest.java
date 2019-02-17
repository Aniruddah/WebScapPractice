package io.mavenchu.Scraping;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;


public class WebScrapingTest {
	private static WebClient webClient = null;
	String baseUrl = "https://bikroy.com/bn/ads/bangladesh/jobs";

	@Test
	public void testWebScrap() throws Exception {
	WebClient webClient = new WebClient();
	
	webClient.getOptions().setJavaScriptEnabled(false); 
	
	HtmlPage page = webClient.getPage("https://bikroy.com/bn/ads/bangladesh/jobs");
	
	System.out.println(page.getTitleText());
	System.out.println();
	}
	
	
	public void getScrapedJobs(HtmlPage page) throws IOException {
	try {
		
		
	List<HtmlElement> list = (List<HtmlElement>) page.getBody().getByXPath("//div[@class = 'item-content']/a");
	
	for (int i = 0; i < list.size(); i++) {
	
		String S = baseUrl + list.get(i).getByXPath("//div[@class = 'ui-panel is-transparent serp-results]/item-content(i)/a/href");
		
//		String loc = list.get(i).getElementsByTagName("td").get(2).getTextContent().trim();
//		String jn = list.get(i).getElementsByTagName("td").get(1).getTextContent().trim();

			
		System.out.println("Job Url: "+S);
//		System.out.println("Job loc: "+loc);
//		System.out.println("Job Name: "+jn);
		System.out.println();
	}
		} catch (FailingHttpStatusCodeException e) {
			System.out.println(" failed to connect site");
		}
	}
	
	

	private WebClient getWebClient() {
		// TODO Auto-generated method stub
		return null;
	}
}
		


	
	
	
	


