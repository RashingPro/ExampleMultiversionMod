package org.example.multiversion_mod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.minecraft.text.Text;
import org.example.multiversion_mod_shared.Player;
import org.example.multiversion_mod_shared.SharedModule;

public class ExampleMod implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ClientCommandRegistrationCallback.EVENT.register(
                (commandDispatcher, commandRegistryAccess) ->
                        commandDispatcher.register(ClientCommandManager.literal("example")
                                .executes(commandContext -> {
                                    SharedModule.sendHello((Player) commandContext.getSource().getPlayer(), Text::literal);
                                    return 0;
                                })
                        )
        );
    }
}
