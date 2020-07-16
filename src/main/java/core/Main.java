package core;

import events.CakeCmd;
import events.HelloCmd;
import events.MusicCmd;
import events.swedishCmd;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import util.SECRET;

import javax.security.auth.login.LoginException;

public class Main {
    public static void main(String[] args) throws LoginException {


        JDABuilder jdaBuilder = new JDABuilder(AccountType.BOT);
        jdaBuilder.setToken(new SECRET().getSecret());
        jdaBuilder.setStatus(OnlineStatus.ONLINE);
        jdaBuilder.addEventListeners(new HelloCmd());
        jdaBuilder.addEventListeners(new CakeCmd());
        jdaBuilder.addEventListeners(new MusicCmd());
        jdaBuilder.addEventListeners(new swedishCmd());
        jdaBuilder.build();

    }
}
