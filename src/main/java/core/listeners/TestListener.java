package core.listeners;

import lombok.extern.log4j.Log4j2;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

@Log4j2
public class TestListener implements ITestListener {
  @Override
  public void onFinish(ITestContext result) {
    // TODO Auto-generated method stub
  }

  @Override
  public void onStart(ITestContext result) {
    // TODO Auto-generated method stub
  }

  @Override
  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    // TODO Auto-generated method stub
  }

  @Override
  public void onTestFailure(ITestResult result) {
    log.info(String.format("The name of the testcase failed is %s:", result.getName()));
  }

  @Override
  public void onTestSkipped(ITestResult result) {
    log.info(String.format("The name of the testcase skipped is %s:", result.getName()));
  }

  @Override
  public void onTestStart(ITestResult result) {
    log.info(String.format("%s: test case started", result.getName()));
  }

  @Override
  public void onTestSuccess(ITestResult result) {
    log.info(String.format("The name of the testcase passed is %s:", result.getName()));
  }
}
