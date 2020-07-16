package events;


import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import java.util.ArrayList;

public class swedishCmd extends ListenerAdapter {

    Dictionary swedish = new Dictionary("swedish");
    String[] word1 = {"hej", "hej, jag heter Sven"};
    Data data = new Data();



    @Override
    public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent event) {
        String[] messageSent = event.getMessage().getContentRaw().toLowerCase().split(" ");
        String getUserName = event.getMember().getUser().getName();
        ArrayList<String> openConversation = new ArrayList<String>();
        super.onGuildMessageReceived(event);
        swedish.setContent("hello", word1);

        String[][] dataList = data.data;

        for (String[] dataset : dataList){
            String[] valuedata = {dataset[1], dataset[2]};
            swedish.setContent(dataset[0], valuedata);

        }
        ArrayList<String> content = swedish.getContent();



        if (messageSent[0].equals("corneliasbot") && messageSent[1].equals("whats") && messageSent[4].equals("swedish")){

            if (!event.getMember().getUser().isBot() && swedish.getContentDict().containsKey(messageSent[2])){

                event.getChannel().sendMessage(swedish.translateWord(messageSent[2])).queue();

            }
            else{
                event.getChannel().sendMessage("Sorry i dont know the answer").queue();

            }




    }
}


}
