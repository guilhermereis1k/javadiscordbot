package org.example;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.track.playback.MutableAudioFrame;
import net.dv8tion.jda.api.audio.AudioReceiveHandler;

import java.nio.ByteBuffer;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class AudioSendHandler implements net.dv8tion.jda.api.audio.AudioSendHandler, AudioReceiveHandler {
    private final AudioPlayer audioPlayer;
    private ByteBuffer buffer = ByteBuffer.allocate(1024);
    private MutableAudioFrame frame = new MutableAudioFrame();

    public AudioSendHandler(AudioPlayer audioPlayer) {
        this.audioPlayer = audioPlayer;
        frame.setBuffer(buffer);
    }


    @Override
    public boolean canProvide() {
        return audioPlayer.provide(frame);
    }

    @Override
    public ByteBuffer provide20MsAudio() {
        return buffer.flip();
    }

    @Override
    public boolean isOpus() {
        return false;
    }
}
