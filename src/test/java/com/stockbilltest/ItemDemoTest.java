package com.stockbilltest;

import com.stockbill.Item;
import com.stockbill.Shop;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by hsenid on 10/17/16.
 */
public class ItemDemoTest {

    Shop newShop = new Shop();

    @Test
    public void testCheckPrice() {
        Double realAns=newShop.checkPrice(0);
        Double expectedAns=0.0;

        assertEquals(realAns,expectedAns);

    }

    @Test
    public void testSearch() {
        Item itemReal=newShop.search("sugar");
        Item itemExpected=null;

        assertEquals(itemReal,itemExpected);


    }

}
