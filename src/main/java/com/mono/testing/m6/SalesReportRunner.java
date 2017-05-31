package com.mono.testing.m6;

import java.io.PrintStream;

// This is the app itself (command line)
public class SalesReportRunner {

    private final PrintStream out;


    public SalesReportRunner(final PrintStream out) {
        this.out = out;
    }
 
    public static void main(String[] args){
        String fileLocation = args[0];
        new SalesReportRunner(System.out).run(fileLocation);
    }

    public void run(String fileLocation) {
        // input
        SalesRepository repo = new SalesRepository(fileLocation);
        // biz logic
        SalesAnalyser analyser = new SalesAnalyser(repo);
        // output - view
        SalesReport report = new SalesReport(analyser, out);
        report.run();
    }
}
