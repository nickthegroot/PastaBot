package utils;

import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.ReadyEvent;
import sx.blah.discord.handle.obj.Status;

public class InterfaceListener {

    @EventSubscriber
    public void onReadyEvent(ReadyEvent event) {
        event.getClient().changeStatus(Status.game("~help | " + String.valueOf(event.getClient().getGuilds().size()+1) + " Servers"));
        System.out.println("" +
                "Yo\n" +
                "His palms are sweaty, knees weak, arms are heavy\n" +
                "There's vomit on his sweater already, mom's spaghetti\n\n" +
                "Bot Ready");
    }
}
