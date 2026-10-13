package com.Victorious91.homework;

public class TestConfigRunner{
    public static void main (String[] args){
        BrowserConfig browserConstructor1 = new BrowserConfig(BrowserType.FIREFOX,"13.4",true);
        BrowserConfig browserConstructor2 = new BrowserConfig(BrowserType.EDGE,"69.9");
        BrowserConfig browserConstructor3 = new BrowserConfig(BrowserType.CHROME);

        BrowserConfig config = BrowserConfig.createDefaultChromeConfig();

        browserConstructor1.afiseazaConfig();
        browserConstructor2.afiseazaConfig();
        browserConstructor3.afiseazaConfig();
        config.afiseazaConfig();

    }

}