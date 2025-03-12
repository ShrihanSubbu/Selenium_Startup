package reports;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.commons.io.FileUtils;
import org.example.BaseTest;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.example.BaseTest.driver;

public class ExtentReportListener extends ExtentManager implements ITestListener {

    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getName());
    }

    public void onTestSuccess(ITestResult result) {
        if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, "Pass Test case is: " + result.getName());
        }
    }

    public void onTestFailure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {

            test.log(Status.FAIL,
                    MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
            test.log(Status.FAIL,
                    MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
            /*try {
                test.log(Status.FAIL, (Markup) test.addScreenCaptureFromPath(captureScreen()));
            } catch (IOException e) {
                e.printStackTrace();
            }*/
            try {
                captureScreen(result);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public void onTestSkipped(ITestResult result) {
        if (result.getStatus() == ITestResult.SKIP) {
            test.log(Status.SKIP, "Skipped Test case is: " + result.getName());
        }
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        test.log(Status.INFO, "Test case failed but within success percentage: " + result.getName());
    }

    public void onStart(ITestContext context) {
        //test.log(Status.INFO, "Test Execution Started");
    }

    public void onFinish(ITestContext context) {
        try {
            Map<String, Object> testResult = new HashMap<>();
            testResult.put("TotalTestCaseCount", context.getAllTestMethods().length);
            testResult.put("PassedTestCaseCount", context.getPassedTests().size());
            testResult.put("FailedTestCaseCount", context.getFailedTests().size());
            testResult.put("SkippedTestCaseCount", context.getSkippedTests().size());

            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            String filePath = "test-output/ExtentReport/TestExecutionReport.json";
            mapper.writeValue(new File(filePath), testResult);
        } catch (IOException e) {
            throw new RuntimeException("Error occurred while writing to TestExecutionReport.json file: ",
                    e);
        }
    }

    public String captureScreen(ITestResult testcase) throws IOException {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss:SSS");
        Date date = new Date();
        String currentDate = dateFormat.format(date);
        currentDate = currentDate.replace(" ", "").replaceAll("/", "").replaceAll(":", "");
        TakesScreenshot screen = (TakesScreenshot) driver;
        File src = screen.getScreenshotAs(OutputType.FILE);
        String dest = System.getProperty("user.dir") +"//test-output//screenshots//" +testcase.getName()+ currentDate + ".png";
        File target = new File(dest);
        FileUtils.copyFile(src, target);
        return dest;
    }
}
