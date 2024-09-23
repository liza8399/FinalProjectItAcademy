package com.itacademy.listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("=======================================================");
        System.out.println("Test " + result.getMethod().getMethodName() + " started");
        System.out.println("=======================================================");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("=======================================================");
        System.out.println("Test " + result.getMethod().getMethodName() + " success");
        System.out.println("=======================================================");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("=======================================================");
        System.out.println("Test " + result.getMethod().getMethodName() + " FAILED");
        System.out.println("=======================================================");
    }
}
