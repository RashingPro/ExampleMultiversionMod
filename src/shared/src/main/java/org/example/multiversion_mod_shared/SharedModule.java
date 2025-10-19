package org.example.multiversion_mod_shared;

import java.util.function.Function;

public class SharedModule {
    private static String getHello() {
        return "Hello from SharedModule!";
    }

    public static void sendHello(Player player, Function<String, Object> strToText) {
        player.sendMessage(strToText.apply(getHello()), true);
    }
}
