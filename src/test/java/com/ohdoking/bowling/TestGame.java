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
        Assert.assertEquals(1, g.getCurrentFrame());
    }

    @Test
    public void testTwoThrowNoMark(){
        g.add(5);
        g.add(4);
        Assert.assertEquals(9, g.score());
        Assert.assertEquals(2, g.getCurrentFrame());
    }

    @Test
    public void testFourThrowsNoMark(){
        g.add(5);
        g.add(4);
        g.add(7);
        g.add(2);

        Assert.assertEquals(18, g.score());
        Assert.assertEquals(9, g.scoreForFrame(1));
        Assert.assertEquals(18, g.scoreForFrame(2));
        Assert.assertEquals(3, g.getCurrentFrame());
    }

    @Test
    public void testSimpleSpare(){
        g.add(3);
        g.add(7);
        g.add(3);
        Assert.assertEquals(13, g.scoreForFrame(1));
        Assert.assertEquals(2, g.getCurrentFrame());
    }

    @Test
    public void testSimpleFrameAfterSpare(){
        g.add(3);
        g.add(7);
        g.add(3);
        g.add(2);
        Assert.assertEquals(13, g.scoreForFrame(1));
        Assert.assertEquals(18, g.scoreForFrame(2));
        Assert.assertEquals(3, g.getCurrentFrame());
        Assert.assertEquals(18, g.score());
    }

    @Test
    public void testSimpleStrike(){
        g.add(10);
        g.add(3);
        g.add(6);
        Assert.assertEquals(19, g.scoreForFrame(1));
        Assert.assertEquals(28, g.score());
        Assert.assertEquals(3, g.getCurrentFrame());
    }

    @Test
    public void testPerfectGame(){
        for(int i = 0 ; i < 12 ; i++){
            g.add(10);
        }
        Assert.assertEquals(300, g.score());
        Assert.assertEquals(10, g.getCurrentFrame());
    }

    @Test
    public void testEndOfArray(){
        for(int i = 0 ; i < 9 ; i++){
            g.add(0);
            g.add(0);
        }
        g.add(2);
        g.add(8); // spare in last frame
        g.add(10); // strike in last throw
        Assert.assertEquals(20, g.score());
        Assert.assertEquals(10, g.getCurrentFrame());
    }

    @Test
    public void testSampleGame(){
        g.add(1);
        g.add(4);
        g.add(4);
        g.add(5);
        g.add(6);
        g.add(4);
        g.add(5);
        g.add(5);
        g.add(10);
        g.add(0);
        g.add(1);
        g.add(7);
        g.add(3);
        g.add(6);
        g.add(4);
        g.add(10);
        g.add(2);
        g.add(8);
        g.add(6);
        Assert.assertEquals(133, g.score());
        Assert.assertEquals(10, g.getCurrentFrame());
    }

    @Test
    public void testHeartBreaker(){
        for(int i = 0 ; i < 11 ; i++){
            g.add(10);
        }
        g.add(9);
        Assert.assertEquals(299, g.score());
        Assert.assertEquals(10, g.getCurrentFrame());
    }

    @Test
    public void testTenthFrameSpare(){
        for(int i = 0 ; i < 9 ; i++){
            g.add(10);
        }
        g.add(9);
        g.add(1);
        g.add(1);
        Assert.assertEquals(270, g.score());
        Assert.assertEquals(10, g.getCurrentFrame());
    }
}
