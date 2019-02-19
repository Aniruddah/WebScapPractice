package io.mavenchu.Scraping;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlParagraph;
import com.gargoylesoftware.htmlunit.html.HtmlSpan;


public class WebScrapingTest {
	private static final WebClient CLIENT= getClient();
	private String Url = "https://bikroy.com/bn/ads/bangladesh/jobs";
	
	private static WebClient getClient() {
		WebClient myClient= new WebClient();
		myClient.getOptions().setTimeout(10*1000);
		myClient.getOptions().setJavaScriptEnabled(false);
		myClient.getOptions().setCssEnabled(false);
		myClient.setJavaScriptTimeout(8*1000);
		myClient.getOptions().getSSLInsecureProtocol();
		return myClient;
	}
	
	@Test
	public void getScrapedJobs() throws IOException, InterruptedException {
		HtmlPage page = CLIENT.getPage(Url);
		CLIENT.waitForBackgroundJavaScript(8*1000);
		Thread.sleep(3*1000);
		System.out.println(page.getUrl());
		System.out.println(page.getTitleText());
		System.out.println();
		
		
		List <HtmlAnchor> anchorUrl = (List<HtmlAnchor>) page.getBody().getByXPath("//a[@class='item-title h4']");
		List <HtmlSpan> spanArea = (List<HtmlSpan>) page.getBody().getByXPath("//span[@class='item-area']");
        List <HtmlParagraph> spanCompany = (List<HtmlParagraph>) page.getBody().getByXPath("//p[@class='item-meta']");
		for (HtmlAnchor row :anchorUrl) {
		System.out.println("Job Url: "+Url+row.getAttribute("href").toString());
		System.out.println("Job Tilte: "+row.getTextContent());
//		System.out.println("Company Name: "+row.getTextContent());
		System.out.println();
	}
		
		for (HtmlParagraph row :spanCompany) {
			System.out.println("Company Name: "+row.getTextContent());
		}
}
}

		


	
	
	
	


