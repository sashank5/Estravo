package com.huawei.estravo;

public class Model_card_class {
    private int imageview;
    private String textview1;
    private String textview2;


    Model_card_class(int imageview , String textview1, String textview2)
    {
        this.imageview=imageview;
        this.textview1=textview1;
        this.textview2=textview2;
    }

    public int getImageview() {
        return imageview;
    }

    public String getTextview1() {
        return textview1;
    }

    public String getTextview2() {
        return textview2;
    }

}
