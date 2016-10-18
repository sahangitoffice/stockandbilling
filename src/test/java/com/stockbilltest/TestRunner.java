package com.stockbilltest;

import com.stockbill.ItemDemo;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Created by hsenid on 10/18/16.
 */
public class TestRunner {

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(ItemDemoTest.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(result.wasSuccessful());
    }

}
