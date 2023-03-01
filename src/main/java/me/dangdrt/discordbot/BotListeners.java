package me.dangdrt.discordbot;

import me.dangdrt.webscraper.Webscraper;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.utils.FileUpload;

import java.io.File;

public class BotListeners extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        super.onMessageReceived(event);


        if (!event.getAuthor().isBot()) {
            String messageSent = event.getMessage().getContentRaw();
            if (messageSent.equals("begin scrape")) {
                event.getChannel().sendMessage("Affirmative, beginning scrape").queue();

                Webscraper webscraper = new Webscraper();
                webscraper.scrape("https://barbora.lt/darzoves-ir-vaisiai/darzoves-ir-grybai/pomidorai-ir-agurkai");
            }
        }
    }
}
