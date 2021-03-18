package com.ohdoking.bowling;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestGame {

    Game g;

    @Before
    public void init(){
        g = new Game();
    }

    @Test
    public void testOneThrow(){
        g.add(5);
        Assert.assertEquals(5, g.score());
    }

    @Test
    public void testTwoThrowNoMark(){
        g.add(5);
        g.add(4);
        Assert.assertEquals(9, g.score());
    }



}
