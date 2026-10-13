package com.Victorious91.homework;
public class BrowserConfig {
    private BrowserType browser;
    private String version;
    private boolean isHeadless;

    //Primul constructor, primeste 3 parametrii si ii atribuie campurilor clasei.
    public BrowserConfig(BrowserType browser,String version,boolean isHeadless){
        this.browser = browser;
        this.version = version;
        this.isHeadless = isHeadless;
    }

    //Al doilea constructor, primeste 2 parametrii si apeleaza primul constructor.
    public BrowserConfig(BrowserType browser, String version){
        this(browser,version,false);
    }

    //Al treilea constructor, primeste 1 parametru si apeleaza al doilea constructor.
    public BrowserConfig(BrowserType browser){
        this(browser, "latest");
    }

    //Metoda default returneaza Browser-ul Chrome pe ultima versiune si ruleaza in background.
    public static BrowserConfig createDefaultChromeConfig(){
        return new BrowserConfig(BrowserType.CHROME, "latest", true);
    }

    //Metoda pentru afisare configuratie
    public void afiseazaConfig(){
        System.out.println("Browser: "+this.browser+", Version: "+this.version+", Headless: "+this.isHeadless);
    }


}
