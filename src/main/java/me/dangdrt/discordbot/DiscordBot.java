package me.dangdrt.discordbot;

import me.dangdrt.webscraper.Webscraper;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;
import java.io.*;
import java.util.Properties;

public class DiscordBot {
    public static void main(String[] args) throws LoginException {
        try (InputStream input = new FileInputStream("src/main/resources/config.properties")) {
            Properties properties = new Properties();
            properties.load(input);

            JDA bot = JDABuilder.createDefault(properties.getProperty("db.token"))
                    .setActivity(Activity.playing("with your mom"))
                    .enableIntents(GatewayIntent.MESSAGE_CONTENT, GatewayIntent.DIRECT_MESSAGES)
                    .addEventListeners(new BotListeners())
                    .build();

        } catch (IOException io) {
            io.printStackTrace();
        }

    }
}