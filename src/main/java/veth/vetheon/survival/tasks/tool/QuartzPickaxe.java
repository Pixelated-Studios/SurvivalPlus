package veth.vetheon.survival.tasks.tool;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import veth.vetheon.survival.Survival;
import veth.vetheon.survival.managers.ItemManager;
import veth.vetheon.survival.item.Item;

public class QuartzPickaxe extends BukkitRunnable {

	private final Survival plugin;

	public QuartzPickaxe(Survival plugin) {
		this.plugin = plugin;
		this.runTaskTimer(plugin, 1, 10);
	}

	@Override
	public void run() {
		for (Player player : plugin.getServer().getOnlinePlayers()) {
			if (ItemManager.compare(player.getInventory().getItemInMainHand(), Item.QUARTZ_PICKAXE)) {
				player.removePotionEffect(PotionEffectType.FAST_DIGGING);
				player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 20, 9, false));
			}
		}
	}

}

