package com.Victorious91.tests.config;

/**
 * Configurare centralizata. Valorile pot fi suprascrise din linia de comanda, de exemplu:
 * mvn test "-DbaseUrl=https://www.saucedemo.com" "-Dbrowser=chrome" "-Dheadless=true"
 *
 * Credentialele implicite sunt cele publice afisate chiar pe pagina de login saucedemo.com.
 */
public final class TestConfig {

    private TestConfig() {
    }

    public static String baseUrl() {
        String url = get("baseUrl", "https://www.saucedemo.com");
        return url.endsWith("/") ? url.substring(0, url.length() - 1) : url;
    }

    public static String browser() {
        return get("browser", "firefox");
    }

    public static boolean headless() {
        return Boolean.parseBoolean(get("headless", "false"));
    }

    public static String validUser() {
        return get("saucedemo.user", "standard_user");
    }

    public static String validPassword() {
        return get("saucedemo.password", "secret_sauce");
    }

    /** Maven transmite proprietatile nesetate ca "${...}" sau string gol, deci le ignoram. */
    private static String get(String key, String defaultValue) {
        String value = System.getProperty(key);
        if (value == null || value.isBlank() || value.startsWith("${")) {
            return defaultValue;
        }
        return value;
    }
}
