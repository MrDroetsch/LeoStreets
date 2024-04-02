package me.bunny;

import java.util.Locale;
import java.util.ResourceBundle;

public class Messages {

    private Messages() {}

    public enum Msg {
        ERR_NOT_ENOUGH_MONEY,

        TXT_WELCOME
    }

    private static String RES_BUNDLE = "Texts";

    public static String getMessageText(Msg msgKey, Locale locale) {
        return ResourceBundle.getBundle(RES_BUNDLE, locale).getString(msgKey.name());
    }

    public static String getMessageText(Msg msgKey) {
        return getMessageText(msgKey, Main.defaultLocale);
    }

}
