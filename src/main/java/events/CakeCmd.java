package events;

import com.vdurmont.emoji.EmojiParser;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import java.util.ArrayList;

public class CakeCmd extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent event) {
        String[] messageSent = event.getMessage().getContentRaw().split(" ");
        String getUserName = event.getMember().getUser().getName();
        ArrayList<String> openConversation = new ArrayList<String>();

        if (messageSent[0].equals("i want cake") || (messageSent.length > 2 && messageSent[2].equals("cake"))) {
            if (!event.getMember().getUser().isBot()) {


                event.getChannel().sendMessage(String.format("%s", EmojiParser.parseToUnicode(":cake:"))).queue();
                openConversation.add(getUserName);

                System.out.println(openConversation);

            }

        }


    }
}
