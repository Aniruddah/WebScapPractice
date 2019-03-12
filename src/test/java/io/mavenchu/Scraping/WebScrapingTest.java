 package io.mavenchu.Scraping;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;


public class WebScrapingTest {
	private static final WebClient CLIENT= getClient();
	private String Url = "https://bikroy.com/bn/ads/bangladesh/jobs?page=1";
	private String baseUrl = "https://bikroy.com";
//	private List<Job> jobList = new ArrayList<>();
	
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

		
		List<HtmlElement> jobList= (List<HtmlElement>) page.getBody().getByXPath("//div[@class='item-content']");
		
		for(int i=0;i<jobList.size();i++) {
			
			String jobTitle=jobList.get(i).getElementsByTagName("a").get(0).getTextContent();
			String jobUrl=jobList.get(i).getElementsByTagName("a").get(0).getAttribute("href");
			String companyName=jobList.get(i).getElementsByTagName("span").get(0).getTextContent();
			String jobLocation=jobList.get(i).getElementsByTagName("p").get(2).getElementsByTagName("span").get(1).getTextContent();
			String jobSalary=jobList.get(i).getElementsByTagName("p").get(1).getElementsByTagName("strong").get(0).getTextContent();
			
			
			System.out.println("Job No. : "+(i+1));
			System.out.println("Job title: "+jobTitle);
			System.out.println("Job Url: "+baseUrl+jobUrl);
			System.out.println("Company Name: "+companyName);
			System.out.println("Job Location: "+jobLocation);
			System.out.println("Job Salary: "+jobSalary);
			
			
			System.out.println();
			System.out.println();
			
			
		}
		
		List<HtmlElement> jobs1=(List<HtmlElement>) page.getBody().getByXPath("//span[@class='t-small summary-count']");
		String totalJobs=jobs1.get(0).getTextContent().substring(0,3);
		int totalJobPages=Integer.parseInt(totalJobs)/27;
		System.out.println("Total Jobs: "+totalJobs);
		System.out.println("Total Job Pages: "+totalJobPages);
		

	}
}
	



		


	
	
	
	


