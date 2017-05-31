package com.mono.testing.m6;

import org.junit.Test;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;


public class SalesReportSystemTest {
    @Test
    public void ShouldPrintStoreReportForSampleData() {
        // arrange
        ApplicationRunner runner = new ApplicationRunner();
        String report = runner.run("src/main/resources/example-sales.csv");
        // act

        // assert
        assertThat(report, containsString("London 235"));
    }

}
