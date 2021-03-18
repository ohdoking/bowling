package com.ohdoking.bowling;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TestFrame {

    Frame f;

    @Before
    public void init(){
        f = new Frame();
    }

    @Test
    public void testScoreNoThrows(){

        Assert.assertEquals(0, f.getScore());
    }

    @Test
    public void testAddOneThrow(){
        f.add(5);
        Assert.assertEquals(5, f.getScore());
    }
}
