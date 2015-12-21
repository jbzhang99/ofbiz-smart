package org.huihoo.ofbiz.smart.entity;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

public class BaseTestCase {

    protected Delegator delegator;
    protected boolean testMode = true;
    @Before
    public void before() {
        init();
        Assert.assertNotNull(delegator);
        if (testMode) delegator.beginTransaction();
    }

    public void init() {
        try {
            delegator = new EbeanDelegator();
        } catch (GenericEntityException e) {
            e.printStackTrace();
        }
    }

    @After
    public void endup() {
        if (testMode && delegator != null) {
            delegator.rollback();
            delegator.endTransaction();
        }
    }
}
