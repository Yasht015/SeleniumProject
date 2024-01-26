package utility;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import base.TestBase;

public class ExtentReportManager extends TestBase
{
	static ExtentReports reports;
	public static ExtentReports getReportInstance()
	{
		if(reports==null)
		{
			String reportsname=new SimpleDateFormat("dd-mm-yy ss-mm-HH").format(new Date());
			ExtentHtmlReporter htmlreporter=new ExtentHtmlReporter("C:\\Users\\Sachin Todankar\\eclipse-workspace\\Selenium_28th_Batch\\ExtentReport\\report.html");
			reports=new ExtentReports();
			reports.attachReporter(htmlreporter);
			reports.setSystemInfo("OS", "Windows");
			reports.setSystemInfo("Environment", "SIT");
			reports.setSystemInfo("Build Number", "102.02.02.126");
			reports.setSystemInfo("Browser", "Chrome");
			htmlreporter.config().setDocumentTitle("UI Testing documents");
			htmlreporter.config().setReportName("UI Test Report");
		}
		return reports;
		
	}
	
	
}
