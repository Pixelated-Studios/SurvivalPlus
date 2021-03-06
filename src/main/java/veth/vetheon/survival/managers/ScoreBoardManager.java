package veth.vetheon.survival.managers;

import org.bukkit.entity.Player;
import veth.vetheon.survival.Survival;
import veth.vetheon.survival.data.Board;
import veth.vetheon.survival.tasks.Healthboard;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ScoreBoardManager {

    private final Survival plugin;
    private final Map<UUID, Healthboard> playerBoards = new HashMap<>();

    public ScoreBoardManager(Survival plugin) {
        this.plugin = plugin;
    }

    /** Sets up a scoreboard for a player
     * <p>
     *     This is generally used internally
     * </p>
     * @param player Player to setup a scoreboard for
     */
    public void setupScoreboard(Player player) {
        playerBoards.put(player.getUniqueId(), new Healthboard(plugin, player));
    }

    public void resetStatusScoreboard(boolean enabled) {
        for (Player player : plugin.getServer().getOnlinePlayers()) {
            if (enabled)
                setupScoreboard(player);
            else
                Board.removeBoard(player);
        }
    }

    public void unloadScoreboard(Player player) {
        if (playerBoards.containsKey(player.getUniqueId())) {
            playerBoards.get(player.getUniqueId()).cancel();
            playerBoards.remove(player.getUniqueId());
        }
    }

}
