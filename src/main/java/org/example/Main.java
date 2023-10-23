package org.example;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.player.DefaultAudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.source.AudioSourceManagers;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.managers.AudioManager;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import org.example.commands.BotCommands;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        JDA bot = JDABuilder.createDefault("MTE2NjA4NzQ4NDc1Nzc3ODQ4Mg.GRoqBH.2mXejN2HAbs2J5R8SCn9exsVsFFqdBLFHpPNds", GatewayIntent.GUILD_MESSAGES, GatewayIntent.GUILD_MESSAGE_REACTIONS, GatewayIntent.MESSAGE_CONTENT)
                .setMemberCachePolicy(MemberCachePolicy.ALL)
                .enableIntents(GatewayIntent.GUILD_MESSAGES, GatewayIntent.GUILD_MESSAGE_REACTIONS, GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_VOICE_STATES, GatewayIntent.GUILD_MEMBERS)
                .setActivity(Activity.playing("de luva"))
                .enableCache(CacheFlag.VOICE_STATE)
                .addEventListeners(new BotCommands())
                .build().awaitReady();

        Guild guild = bot.getGuildById("1124074890450960435");

        EasyCommands easyCommands =

        if (guild != null) {
            guild.upsertCommand("receba", "RECEBA CARALHO, MELHOR DO MUNDO PAI").queue();
        }
    }
}