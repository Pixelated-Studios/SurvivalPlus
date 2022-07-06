package veth.vetheon.survival.listeners.server;

import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.event.ClickEvent;
import net.kyori.adventure.text.event.HoverEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import veth.vetheon.survival.Survival;
import veth.vetheon.survival.config.Config;
import veth.vetheon.survival.config.Lang;
import veth.vetheon.survival.util.Utils;

public class Guide implements Listener {
    
    private Survival plugin;
    private Lang lang;
    private Config config;
    
    public Guide(Survival plugin) {
        this.plugin = plugin;
        this.lang = plugin.getLang();
        this.config = plugin.getSurvivalConfig();
    }

    @EventHandler
    private void onJoin(PlayerJoinEvent e) {
        if (e.getPlayer().hasPlayedBefore() && config.WELCOME_GUIDE_NEW_PLAYERS) return;
        int delay = config.WELCOME_GUIDE_DELAY;
        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, () -> {
            Player player = e.getPlayer();
            Audience playeraud = Audience.audience(player);
            TextComponent msg = Utils.getColoredString(lang.survival_guide_msg);
            TextComponent link = Utils.getColoredString(lang.survival_guide_click_msg);
            link = link.clickEvent(ClickEvent.clickEvent(ClickEvent.Action.OPEN_URL, lang.survival_guide_link));
            link = link.hoverEvent(HoverEvent.hoverEvent(HoverEvent.Action.SHOW_TEXT, Utils.getColoredString(lang.survival_guide_hover_msg)));
            msg = msg.append(link);
            playeraud.sendMessage(msg);
        }, 20 * delay);
    }

}
