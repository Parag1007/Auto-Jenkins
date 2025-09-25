package com.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

	 
	    private static ExtentReports extent;

	    public static ExtentReports getInstance() {
	        if (extent == null) {
	            String reportPath = System.getProperty("user.dir") + "/extent-reports/extent.html";
	            ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
	            reporter.config().setReportName("Automation Test Results");
	            reporter.config().setDocumentTitle("Extent Report");

	            extent = new ExtentReports();
	            extent.attachReporter(reporter);
	        }
	        return extent;
	    }
	}

	
 