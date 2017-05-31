package com.mono.testing.m6;

import org.junit.Test;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;


public class SalesRepositoryTest {
    @Test
    public void shouldLodeSampleData() {
        // arrange
        SalesRepository _sut = new SalesRepository("src/main/resources/example-sales.csv");
        // act
        List<Sale> output = _sut.loadSales();
        // assert
        assertThat(output, hasItem(allOf(
                hasProperty("store", equalTo("London")),
                hasProperty("number", equalTo(2)),
                hasProperty("pricePerItem", equalTo(30))
        )));
    }
}
