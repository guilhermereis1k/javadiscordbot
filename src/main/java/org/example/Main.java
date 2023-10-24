package org.example;

import ca.tristan.easycommands.EasyCommands;
import ca.tristan.easycommands.commands.defaults.HelpCmd;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import org.example.commands.*;

import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws InterruptedException, IOException {
        final GatewayIntent[] gatewaysIntents = {GatewayIntent.GUILD_MESSAGES, GatewayIntent.GUILD_MESSAGE_REACTIONS, GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_VOICE_STATES, GatewayIntent.GUILD_MEMBERS};

        EasyCommands easyCommands = new EasyCommands();

        easyCommands.addExecutor( new HelpCmd(easyCommands), new Receba(), new RecebaEsquisito(), new F(), new XShalter(), new Desumilde())
                .addEnabledCacheFlags(CacheFlag.VOICE_STATE)
                .addGatewayIntents(gatewaysIntents).buildJDA().awaitReady();
    }

}