package com.ohdoking.bowling;

import org.junit.Assert;
import org.junit.Test;


public class TestFrame {

    @Test
    public void testScoreNoThrows(){
        Frame f = new Frame();
        Assert.assertEquals(0, f.getScore());
    }
}
