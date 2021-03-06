package veth.vetheon.survival.tasks;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.World.Environment;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import veth.vetheon.survival.Survival;
import veth.vetheon.survival.data.PlayerData;
import veth.vetheon.survival.events.ThirstLevelChangeEvent;
import veth.vetheon.survival.managers.PlayerManager;

class ThirstDrainNether extends BukkitRunnable {

    private final PlayerManager playerManager;

    ThirstDrainNether(Survival plugin) {
        this.playerManager = plugin.getPlayerManager();
        this.runTaskTimer(plugin, 0, 20 * plugin.getSurvivalConfig().MECHANICS_THIRST_DRAIN_NETHER);
    }

    @Override
    public void run() {
        for (Player player : Bukkit.getServer().getOnlinePlayers()) {
            if (player.getGameMode() != GameMode.SURVIVAL && player.getGameMode() != GameMode.ADVENTURE) continue;
            if (player.getWorld().getEnvironment() != Environment.NETHER) continue;

            PlayerData playerData = playerManager.getPlayerData(player);
            int change = 1;
            // Call thirst level change event
            ThirstLevelChangeEvent event = new ThirstLevelChangeEvent(player, change, playerData.getThirst() - change);
            Bukkit.getPluginManager().callEvent(event);
            if (!event.isCancelled()) {
                playerData.increaseThirst(-change);
            }
        }
    }

}

