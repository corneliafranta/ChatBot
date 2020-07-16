package events;

import com.vdurmont.emoji.EmojiParser;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Arrays;

public class MusicCmd extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent event) {
        String[] messageSent = event.getMessage().getContentRaw().toLowerCase().split(" ");
        String getUserName = event.getMember().getUser().getName();
        ArrayList<String> openConversation = new ArrayList<String>();
        System.out.println(Arrays.toString(messageSent));
        System.out.println("hey");
        System.out.println(messageSent[0]);
        if (messageSent[0].equals("corneliasbot") && messageSent[4].equals("music")) {

            System.out.println(messageSent[1]);
            if (!event.getMember().getUser().isBot()) {

                event.getChannel().sendMessage(String.format("%s https://www.youtube.com/watch?v=qKggnBh2Mdw %s", EmojiParser.parseToUnicode(":musical_note:"),EmojiParser.parseToUnicode(":musical_note:"))).queue(); ;


            }

        }


    }
}

