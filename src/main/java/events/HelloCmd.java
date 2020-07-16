package events;

import com.vdurmont.emoji.EmojiParser;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


public class HelloCmd extends ListenerAdapter {
    ArrayList <String> openConversation = new ArrayList<String>();

    HashMap <String,Integer > dissedBots = new HashMap<String, Integer>();
    @Override
    public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent event) {
        String[] messageSent = event.getMessage().getContentRaw().toLowerCase().split(" ");
        String getUserName = event.getMember().getUser().getName();

        System.out.println("messageSent");
        System.out.println(Arrays.toString(messageSent));
        if(messageSent[0].equals("hey") || messageSent[0].equals("hello")){
            if (!event.getMember().getUser().isBot()){

                String smily = ":grinning:";

                String smilyUnicode = EmojiParser.parseToUnicode(smily);
                System.out.println(smilyUnicode);

                event.getChannel().sendMessage(String.format("Hello %s! Nice to meet you %s. Do you want a slice of cake?", getUserName, smilyUnicode)).queue();
                this.openConversation.add(getUserName);
                System.out.println(this.openConversation);

            }
            else {
                if(!dissedBots.containsKey(getUserName) && !getUserName.equals("CorneliasBot")){
                    event.getChannel().sendMessage(String.format("@%s I don't talk to bots", getUserName)).queue();
                    dissedBots.put(getUserName, 1);
                }
                else if (dissedBots.get(getUserName) == 1){
                    event.getChannel().sendMessage(String.format("@%s .....", getUserName)).queue();
                    dissedBots.replace(getUserName, 2);

                }


            }

        }



        if(messageSent[0].equals("yes") && this.openConversation.contains(getUserName)){
            System.out.println("true");
            event.getChannel().sendMessage(EmojiParser.parseToUnicode(":cake:")).queue();

            this.openConversation.remove(getUserName);

        }else if(messageSent[0].equals("no") && this.openConversation.contains(getUserName)){

            event.getChannel().sendMessage("Ok great more cake for me!!! " + EmojiParser.parseToUnicode(":smiling_imp:")).queue();
            this.openConversation.remove(getUserName);
        }
    }
}
