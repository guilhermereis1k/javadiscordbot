package org.example.commands;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.player.DefaultAudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.source.AudioSourceManagers;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.managers.AudioManager;
import org.example.AudioSendHandler;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class BotCommands extends ListenerAdapter {

    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        String eventName = event.getName();

        if (eventName.equals("receba")) {
            event.deferReply().queue();

            event.getHook().sendMessage("RECEBA CARALHO, MELHOR DO MUNDO PAI").queue();
        }

        if (eventName.equals("desumilde")) {
            event.deferReply().queue();

            event.getHook().sendMessage("ANAO XSHALTER").queue();
        }

        if (eventName.equals("comandos")) {
            event.deferReply().queue();

            event.getHook().sendMessage("/receba /desumilde /xshalter").queue();
        }
    }

    public void onMessageReceived(MessageReceivedEvent event) {
        AudioPlayerManager playerManager = new DefaultAudioPlayerManager();
        AudioSourceManagers.registerRemoteSources(playerManager);

        AudioPlayer player = playerManager.createPlayer();

        if (event.getAuthor().isBot()) return;

        String[] command = event.getMessage().getContentRaw().split(" ");

        if (command[0].equalsIgnoreCase("!play")) {
            if (command.length != 1) {
                event.getChannel().sendMessage("Uso correto: `!play`").queue();
                return;
            }

            // Substitua pelo caminho do arquivo MP3 que você deseja reproduzir
            String audioFilePath = "./assets/luva-1.mp3";

            // Verifica se o arquivo MP3 existe
            File audioFile = new File(audioFilePath);
            if (!audioFile.exists()) {
                event.getChannel().sendMessage("Arquivo de áudio não encontrado.").queue();
                return;
            }

            Member member = event.getMember();

            event.getGuild().getAudioManager().openAudioConnection(member.getVoiceState().getChannel());

            // Espera um pouco antes de tocar o áudio (opcional)
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            AudioTrack track = playerManager.loadItem(audioFilePath, null);
            player.playTrack(track);

            event.getGuild().getAudioManager().setSendingHandler(new AudioSendHandler(player));
        }

    }

}
