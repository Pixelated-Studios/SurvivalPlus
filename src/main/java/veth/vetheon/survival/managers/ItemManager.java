package veth.vetheon.survival.managers;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.type.Campfire;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BlockDataMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.inventory.meta.SuspiciousStewMeta;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;
import veth.vetheon.survival.Survival;
import veth.vetheon.survival.config.Lang;
import veth.vetheon.survival.item.Item;
import veth.vetheon.survival.util.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

/**
 * Manager for custom <b>SurvivalPlus</b> items
 */
@SuppressWarnings("ConstantConditions")
public class ItemManager {

    private static final Lang lang = Survival.getInstance().getLang();

    /**
     * Get a custom SurvivalPlus item
     *
     * @param item The item you would like to get
     * @return An ItemStack from a custom item enum
     */
    public static ItemStack get(Item item) {
        if (item == Item.HATCHET) {
            ItemStack i_hatchet = new ItemStack(Item.HATCHET.getMaterialType(), 1);
            ItemMeta hatchetMeta = i_hatchet.getItemMeta();
            hatchetMeta.displayName(Utils.getColoredString(lang.hatchet));
            hatchetMeta.setCustomModelData(Item.HATCHET.getModelData());
            i_hatchet.setItemMeta(hatchetMeta);
            return i_hatchet;
        } else if (item == Item.MATTOCK) {
            ItemStack i_mattock = new ItemStack(Item.MATTOCK.getMaterialType(), 1);
            ItemMeta mattockMeta = i_mattock.getItemMeta();
            mattockMeta.displayName(Utils.getColoredString(lang.mattock));
            mattockMeta.setCustomModelData(Item.MATTOCK.getModelData());
            i_mattock.setItemMeta(mattockMeta);
            return i_mattock;
        } else if (item == Item.SHIV) {
            ItemStack i_shiv = new ItemStack(Item.SHIV.getMaterialType(), 1);
            ItemMeta i_shivMeta = i_shiv.getItemMeta();
            i_shivMeta.setCustomModelData(Item.SHIV.getModelData());

            int shiv_dmg = 4;
            float shiv_spd = 1.8f;

            AttributeModifier i_shivDamage = new AttributeModifier(UUID.fromString("95c4f950-1631-4cc4-9f67-f45d8f087c56"),
                    "generic.attackDamage", shiv_dmg - 1, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
            i_shivMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, i_shivDamage);

            AttributeModifier i_shivSpeed = new AttributeModifier(UUID.fromString("95c4f950-1631-4cc4-9f67-f45d8f087c57"),
                    "generic.attackSpeed", shiv_spd - 4, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
            i_shivMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, i_shivSpeed);

            i_shivMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

            i_shivMeta.displayName(Utils.getColoredString(lang.shiv));
            i_shivMeta.lore(Arrays.asList(
                    Utils.getColoredString(lang.poisoned_enemy),
                    Component.text(""),
                    Utils.getColoredString(lang.in_main_hand),
                    Component.text(" " + shiv_spd + " ").color(TextColor.color(0x00AA00)).append(Utils.getColoredString(lang.attack_speed)),
                    Component.text(" " + shiv_dmg + " ").color(TextColor.color(0x00AA00)).append(Utils.getColoredString(lang.attack_damage)),
                    Component.text(""),
                    Utils.getColoredString(lang.in_off_hand).color(TextColor.color(0x808080)),
                    Utils.getColoredString(lang.poisoned_retain),
                    Utils.getColoredString(lang.reduce_50)
                    )
            );
            i_shiv.setItemMeta(i_shivMeta);
            return i_shiv;
        } else if (item == Item.HAMMER) {
            ItemStack i_hammer = new ItemStack(Item.HAMMER.getMaterialType(), 1);
            ItemMeta hammerMeta = i_hammer.getItemMeta();
            hammerMeta.displayName(Utils.getColoredString(lang.hammer));
            hammerMeta.setCustomModelData(Item.HAMMER.getModelData());
            i_hammer.setItemMeta(hammerMeta);
            return i_hammer;
        } else if (item == Item.VALKYRIES_AXE) {
            ItemStack i_gAxe = new ItemStack(Item.VALKYRIES_AXE.getMaterialType(), 1);
            ItemMeta i_gAxeMeta = i_gAxe.getItemMeta();
            i_gAxeMeta.setCustomModelData(Item.VALKYRIES_AXE.getModelData());

            int gAxe_spd = 1;
            int gAxe_dmg = 8;

            AttributeModifier i_gAxeSpeed = new AttributeModifier(UUID.fromString("95c4f950-1631-4cc4-9f67-f45d8f087c58"),
                    "generic.attackSpeed", gAxe_spd - 4, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
            i_gAxeMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, i_gAxeSpeed);

            i_gAxeMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

            i_gAxeMeta.displayName(Utils.getColoredString(lang.valkyrie_axe));
            i_gAxeMeta.lore(Arrays.asList(
                    Utils.getColoredString(lang.valkyrie_axe_unable_dual),
                    Component.text(""),
                    Utils.getColoredString(lang.in_main_hand).color(TextColor.color(0x808080)),
                    Component.text(" " + gAxe_spd + " ").color(TextColor.color(0x00AA00)).append(Utils.getColoredString(lang.attack_speed)),
                    Component.text(" " + gAxe_dmg + " ").color(TextColor.color(0x00AA00)).append(Utils.getColoredString(lang.attack_damage)),
                    Utils.getColoredString(lang.valkyrie_axe_spin),
                    Component.text("  ").append(Utils.getColoredString(lang.valkyrie_axe_cooldown)),
                    Component.text("  ").append(Utils.getColoredString(lang.decrease_hunger_value))
                    )
            );
            i_gAxeMeta.addEnchant(Enchantment.DURABILITY, 5, true);
            i_gAxe.setItemMeta(i_gAxeMeta);
            return i_gAxe;
        } else if (item == Item.QUARTZ_PICKAXE) {
            ItemStack i_gPickaxe = new ItemStack(Item.QUARTZ_PICKAXE.getMaterialType(), 1);
            ItemMeta i_gPickaxeMeta = i_gPickaxe.getItemMeta();
            i_gPickaxeMeta.setCustomModelData(Item.QUARTZ_PICKAXE.getModelData());

            int gPickaxe_dmg = 5;
            float gPickaxe_spd = 0.8f;

            AttributeModifier i_gPickDamage = new AttributeModifier(UUID.fromString("95c4f950-1631-4cc4-9f67-f45d8f087c59"),
                    "generic.attackDamage", gPickaxe_dmg - 1, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
            i_gPickaxeMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, i_gPickDamage);

            AttributeModifier i_gPickSpeed = new AttributeModifier(UUID.fromString("95c4f950-1631-4cc4-9f67-f45d8f087c60"),
                    "generic.attackSpeed", gPickaxe_spd - 4, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
            i_gPickaxeMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, i_gPickSpeed);

            i_gPickaxeMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

            i_gPickaxeMeta.displayName(Utils.getColoredString(lang.quartz_breaker));
            i_gPickaxeMeta.lore(Arrays.asList(
                    Component.text(""),
                    Utils.getColoredString(lang.in_main_hand).color(TextColor.color(0x808080)),
                    Component.text(" " + gPickaxe_spd + " ").color(TextColor.color(0x00AA00)).append(Utils.getColoredString(lang.attack_speed)),
                    Component.text(" " + gPickaxe_dmg + " ").color(TextColor.color(0x00AA00)).append(Utils.getColoredString(lang.attack_damage)),
                    Component.text(" ").append(Utils.getColoredString(lang.haste)).color(TextColor.color(0x808080))
                    )
            );
            i_gPickaxeMeta.addEnchant(Enchantment.SILK_TOUCH, 1, false);
            i_gPickaxeMeta.addEnchant(Enchantment.MENDING, 1, false);
            i_gPickaxeMeta.addEnchant(Enchantment.BINDING_CURSE, 1, false);
            i_gPickaxe.setItemMeta(i_gPickaxeMeta);
            return i_gPickaxe;
        } else if (item == Item.OBSIDIAN_MACE) {
            ItemStack i_gSpade = new ItemStack(Item.OBSIDIAN_MACE.getMaterialType(), 1);
            ItemMeta i_gSpadeMeta = i_gSpade.getItemMeta();
            i_gSpadeMeta.setCustomModelData(Item.OBSIDIAN_MACE.getModelData());

            int gSpade_dmg = 4;
            float gSpade_spd = 0.8f;
            float gSpade_knockbackPercent = 0.5f;

            AttributeModifier i_gSpadeDamage = new AttributeModifier(UUID.fromString("95c4f950-1631-4cc4-9f67-f45d8f087c61"),
                    "generic.attackDamage", gSpade_dmg - 1, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
            i_gSpadeMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, i_gSpadeDamage);

            AttributeModifier i_gSpadeSpeed = new AttributeModifier(UUID.fromString("95c4f950-1631-4cc4-9f67-f45d8f087c62"),
                    "generic.attackSpeed", gSpade_spd - 4, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
            i_gSpadeMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, i_gSpadeSpeed);

            AttributeModifier i_gSpadeKnock = new AttributeModifier(UUID.fromString("95c4f950-1631-4cc4-9f67-f45d8f087c63"),
                    "generic.knockbackResistance", gSpade_knockbackPercent, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.HAND);
            i_gSpadeMeta.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, i_gSpadeKnock);

            i_gSpadeMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

            i_gSpadeMeta.displayName(Utils.getColoredString(lang.obsidian_mace));
            i_gSpadeMeta.lore(Arrays.asList(
                    Utils.getColoredString(lang.cripple_hit),
                    Utils.getColoredString(lang.drain_hit),
                    Component.text(""),
                    Utils.getColoredString(lang.in_main_hand).color(TextColor.color(0x808080)),
                    Component.text(" " + gSpade_spd + " ").color(TextColor.color(0x00AA00)).append(Utils.getColoredString(lang.attack_speed)),
                    Component.text(" " + gSpade_dmg + " ").color(TextColor.color(0x00AA00)).append(Utils.getColoredString(lang.attack_damage)),
                    Component.text(" ").append(Utils.getColoredString(lang.exhausted_slow)),
                    Component.text(" ").append(Utils.getColoredString(lang.expire_disarm)),
                    Component.text(" ").append(Utils.getColoredString(lang.knockback_resistance))
                    )
            );
            i_gSpadeMeta.addEnchant(Enchantment.KNOCKBACK, 3, true);
            i_gSpadeMeta.addEnchant(Enchantment.DURABILITY, 5, true);
            i_gSpadeMeta.addEnchant(Enchantment.BINDING_CURSE, 1, false);
            i_gSpade.setItemMeta(i_gSpadeMeta);
            return i_gSpade;
        } else if (item == Item.ENDER_GIANT_BLADE) {
            ItemStack i_gHoe = new ItemStack(Item.ENDER_GIANT_BLADE.getMaterialType(), 1);
            ItemMeta i_gHoeMeta = i_gHoe.getItemMeta();
            i_gHoeMeta.setCustomModelData(Item.ENDER_GIANT_BLADE.getModelData());

            int gHoe_dmg = 8;
            int gHoe_spd = 1;
            float gHoe_move = -0.5f;

            AttributeModifier i_gHoeDamage = new AttributeModifier(UUID.fromString("95c4f950-1631-4cc4-9f67-f45d8f087c64"),
                    "generic.attackDamage", gHoe_dmg - 1, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
            i_gHoeMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, i_gHoeDamage);

            AttributeModifier i_gHoeSpeed = new AttributeModifier(UUID.fromString("95c4f950-1631-4cc4-9f67-f45d8f087c65"),
                    "generic.attackSpeed", gHoe_spd - 4, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
            i_gHoeMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, i_gHoeSpeed);

            AttributeModifier i_gHoeMove = new AttributeModifier(UUID.fromString("95c4f950-1631-4cc4-9f67-f45d8f087c66"),
                    "generic.movementSpeed", gHoe_move, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.OFF_HAND);
            i_gHoeMeta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, i_gHoeMove);

            i_gHoeMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

            i_gHoeMeta.displayName(Utils.getColoredString(lang.ender_giant_blade));
            i_gHoeMeta.lore(Arrays.asList(
                    Utils.getColoredString(lang.ender_giant_blade_unable_duel),
                    Component.text(""),
                    Utils.getColoredString(lang.in_main_hand).color(TextColor.color(0x808080)),
                    Component.text(" " + gHoe_spd + " ").color(TextColor.color(0x00AA00)).append(Utils.getColoredString(lang.attack_speed)),
                    Component.text(" " + gHoe_dmg + " ").color(TextColor.color(0x00AA00)).append(Utils.getColoredString(lang.attack_damage)),
                    Component.text("  ").append(Utils.getColoredString(lang.right_click_sprinting).color(TextColor.color(0x808080))),
                    Component.text("  ").append(Utils.getColoredString(lang.ender_giant_blade_charge)),
                    Component.text("  ").append(Utils.getColoredString(lang.ender_giant_blade_cooldown)),
                    Component.text("  ").append(Utils.getColoredString(lang.decrease_hunger_value)),
                    Component.text(""),
                    Utils.getColoredString(lang.in_off_hand).color(TextColor.color(0x808080)),
                    Component.text(" ").append(Utils.getColoredString(lang.half_shield_resistance)),
                    Component.text(" ").append(Utils.getColoredString(lang.reflecting_coming))
                    )
            );
            i_gHoeMeta.addEnchant(Enchantment.DURABILITY, 5, true);
            i_gHoe.setItemMeta(i_gHoeMeta);
            return i_gHoe;
        } else if (item == Item.BLAZE_SWORD) {
            ItemStack i_gSword = new ItemStack(Item.BLAZE_SWORD.getMaterialType(), 1);
            ItemMeta i_gSwordMeta = i_gSword.getItemMeta();
            i_gSwordMeta.setCustomModelData(Item.BLAZE_SWORD.getModelData());

            int gSword_dmg = 6;
            float gSword_spd = 1.6f;
            int gSword_health = -6;

            AttributeModifier i_gSwordDamage = new AttributeModifier(UUID.fromString("95c4f950-1631-4cc4-9f67-f45d8f087c67"),
                    "generic.attackDamage", gSword_dmg - 1, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
            i_gSwordMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, i_gSwordDamage);

            AttributeModifier i_gSwordSpeed = new AttributeModifier(UUID.fromString("95c4f950-1631-4cc4-9f67-f45d8f087c68"),
                    "generic.attackSpeed", gSword_spd - 4, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
            i_gSwordMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, i_gSwordSpeed);

            AttributeModifier i_gSwordHealth = new AttributeModifier(UUID.fromString("95c4f950-1631-4cc4-9f67-f45d8f087c69"),
                    "generic.maxHealth", gSword_health, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
            i_gSwordMeta.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, i_gSwordHealth);

            i_gSwordMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

            i_gSwordMeta.displayName(Utils.getColoredString(lang.blaze_sword));
            i_gSwordMeta.lore(Arrays.asList(
                    Component.text(""),
                    Utils.getColoredString(lang.in_main_hand).color(TextColor.color(0x808080)),
                    Component.text(" " + gSword_spd + " ").color(TextColor.color(0x00AA00)).append(Utils.getColoredString(lang.attack_speed)),
                    Component.text(" " + gSword_dmg + " ").color(TextColor.color(0x00AA00)).append(Utils.getColoredString(lang.attack_damage)),
                    Component.text(" ").append(Utils.getColoredString(lang.blaze_sword_fire_resistance)),
                    Component.text(" ").append(Utils.getColoredString(lang.blaze_sword_fiery)),
                    Component.text(""),
                    Utils.getColoredString(lang.right_click_sneaking).color(TextColor.color(0x808080)),
                    Component.text(" ").append(Utils.getColoredString(lang.blaze_sword_spread_fire)),
                    Component.text(" ").append(Utils.getColoredString(lang.blaze_sword_cost))
                    )
            );
            i_gSwordMeta.addEnchant(Enchantment.FIRE_ASPECT, 2, true);
            i_gSwordMeta.addEnchant(Enchantment.DURABILITY, 3, false);
            i_gSword.setItemMeta(i_gSwordMeta);
            return i_gSword;
        } else if (item == Item.WORKBENCH) {
            ItemStack workbench = new ItemStack(Item.WORKBENCH.getMaterialType(), 1);
            ItemMeta workbenchMeta = workbench.getItemMeta();
            workbenchMeta.displayName(Utils.getColoredString(lang.workbench));
            workbench.setItemMeta(workbenchMeta);
            return workbench;
        } else if (item == Item.FIRESTRIKER) {
            ItemStack i_firestriker = new ItemStack(Item.FIRESTRIKER.getMaterialType(), 1);
            ItemMeta i_firestrikerMeta = i_firestriker.getItemMeta();
            i_firestrikerMeta.setCustomModelData(Item.FIRESTRIKER.getModelData());

            float firestriker_spd = 4f;

            AttributeModifier i_firestrikerSpeed = new AttributeModifier(UUID.fromString("95c4f950-1631-4cc4-9f67-f45d8f087c55"),
                    "generic.attackSpeed",
                    firestriker_spd - 4, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);

            i_firestrikerMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, i_firestrikerSpeed);
            i_firestrikerMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            i_firestrikerMeta.displayName(Utils.getColoredString(lang.firestriker));
            String[] lorelist = lang.firestriker_lore.split("\\|\\|");
            List<Component> lore = new ArrayList<>();
            for (String l : lorelist) {
                lore.add(Utils.getColoredString(l));
            }
            i_firestrikerMeta.lore(lore);
            i_firestriker.setItemMeta(i_firestrikerMeta);
            return i_firestriker;
        } else if (item == Item.FERMENTED_SKIN) {
            ItemStack i_fermentedSkin = new ItemStack(Item.FERMENTED_SKIN.getMaterialType(), 1);
            ItemMeta fermentedSkinMeta = i_fermentedSkin.getItemMeta();
            fermentedSkinMeta.displayName(Utils.getColoredString(lang.fermented_skin));
            i_fermentedSkin.setItemMeta(fermentedSkinMeta);
            return i_fermentedSkin;
        } else if (item == Item.MEDIC_KIT) {
            ItemStack i_medicKit = new ItemStack(Item.MEDIC_KIT.getMaterialType(), 1);
            ItemMeta medicKitMeta = i_medicKit.getItemMeta();
            medicKitMeta.setCustomModelData(Item.MEDIC_KIT.getModelData());
            medicKitMeta.displayName(Utils.getColoredString(lang.medical_kit));
            i_medicKit.setItemMeta(medicKitMeta);
            return i_medicKit;
        } else if (item == Item.REINFORCED_LEATHER_BOOTS) {
            ItemStack i_leatherBoots = new ItemStack(Item.REINFORCED_LEATHER_BOOTS.getMaterialType(), 1);
            ItemMeta i_leatherBootsMeta = i_leatherBoots.getItemMeta();
            i_leatherBootsMeta.setCustomModelData(Item.REINFORCED_LEATHER_BOOTS.getModelData());

            AttributeModifier i_leatherBootsArmor = new AttributeModifier(UUID.fromString("95c4f950-1631-4cc4-9f67-f45d8f087c70"),
                    "generic.armor", 2, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
            i_leatherBootsMeta.addAttributeModifier(Attribute.GENERIC_ARMOR, i_leatherBootsArmor);

            i_leatherBootsMeta.displayName(Utils.getColoredString(lang.reinforced_boots));

            i_leatherBoots.setItemMeta(i_leatherBootsMeta);
            return i_leatherBoots;
        } else if (item == Item.REINFORCED_LEATHER_TUNIC) {
            ItemStack i_leatherChestplate = new ItemStack(Item.REINFORCED_LEATHER_TUNIC.getMaterialType(), 1);

            ItemMeta leatherChestplateMeta = i_leatherChestplate.getItemMeta();
            leatherChestplateMeta.setCustomModelData(Item.REINFORCED_LEATHER_TUNIC.getModelData());
            leatherChestplateMeta.displayName(Utils.getColoredString(lang.reinforced_tunic));

            i_leatherChestplate.setItemMeta(leatherChestplateMeta);
            return i_leatherChestplate;
        } else if (item == Item.REINFORCED_LEATHER_TROUSERS) {
            ItemStack i_leatherLeggings = new ItemStack(Item.REINFORCED_LEATHER_TROUSERS.getMaterialType(), 1);

            ItemMeta leatherLeggingsMeta = i_leatherLeggings.getItemMeta();
            leatherLeggingsMeta.setCustomModelData(Item.REINFORCED_LEATHER_TROUSERS.getModelData());
            leatherLeggingsMeta.displayName(Utils.getColoredString(lang.reinforced_pants));

            i_leatherLeggings.setItemMeta(leatherLeggingsMeta);
            return i_leatherLeggings;
        } else if (item == Item.REINFORCED_LEATHER_HELMET) {
            //Reinforced Leather Helmet
            ItemStack i_leatherHelmet = new ItemStack(Item.REINFORCED_LEATHER_HELMET.getMaterialType(), 1);

            ItemMeta leatherHelmetMeta = i_leatherHelmet.getItemMeta();
            leatherHelmetMeta.setCustomModelData(Item.REINFORCED_LEATHER_HELMET.getModelData());
            leatherHelmetMeta.displayName(Utils.getColoredString(lang.reinforced_hat));

            i_leatherHelmet.setItemMeta(leatherHelmetMeta);
            return i_leatherHelmet;
        } else if (item == Item.GOLDEN_SABATONS) {
            ItemStack i_goldBoots = new ItemStack(Item.GOLDEN_SABATONS.getMaterialType(), 1);
            ItemMeta i_goldBootsMeta = i_goldBoots.getItemMeta();

            AttributeModifier i_goldBootsArmor = new AttributeModifier(UUID.fromString("95c4f950-1631-4cc4-9f67-f45d8f087c71"),
                    "generic.armor", 1, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
            i_goldBootsMeta.addAttributeModifier(Attribute.GENERIC_ARMOR, i_goldBootsArmor);

            AttributeModifier i_goldBootsSpeed = new AttributeModifier(UUID.fromString("95c4f950-1631-4cc4-9f67-f45d8f088c71"),
                    "generic.movementSpeed", -0.0125, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.FEET);
            i_goldBootsMeta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, i_goldBootsSpeed);

            i_goldBootsMeta.displayName(Utils.getColoredString(lang.golden_sabatons));
            i_goldBootsMeta.addEnchant(org.bukkit.enchantments.Enchantment.PROTECTION_FALL, 4, true);

            i_goldBoots.setItemMeta(i_goldBootsMeta);
            return i_goldBoots;
        } else if (item == Item.GOLDEN_GUARD) {
            ItemStack i_goldChestplate = new ItemStack(Item.GOLDEN_GUARD.getMaterialType(), 1);
            ItemMeta i_goldChestplateMeta = i_goldChestplate.getItemMeta();

            AttributeModifier i_goldChestArmor = new AttributeModifier(UUID.fromString("95c4f950-1631-4cc4-9f67-f45d8f087c72"),
                    "generic.armor", 3, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
            i_goldChestplateMeta.addAttributeModifier(Attribute.GENERIC_ARMOR, i_goldChestArmor);

            AttributeModifier i_goldChestSpeed = new AttributeModifier(UUID.fromString("95c4f950-1631-4cc4-9f67-f45d8f088c72"),
                    "generic.movementSpeed", -0.02, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.CHEST);
            i_goldChestplateMeta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, i_goldChestSpeed);

            i_goldChestplateMeta.displayName(Utils.getColoredString(lang.golden_guard));
            i_goldChestplateMeta.addEnchant(org.bukkit.enchantments.Enchantment.PROTECTION_EXPLOSIONS, 4, true);

            i_goldChestplate.setItemMeta(i_goldChestplateMeta);
            return i_goldChestplate;
        } else if (item == Item.GOLDEN_GREAVES) {
            ItemStack i_goldLeggings = new ItemStack(Item.GOLDEN_GREAVES.getMaterialType(), 1);
            ItemMeta i_goldLeggingsMeta = i_goldLeggings.getItemMeta();

            AttributeModifier i_goldLeggingsArmor = new AttributeModifier(UUID.fromString("95c4f950-1631-4cc4-9f67-f45d8f087c73"),
                    "generic.armor", 2, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
            i_goldLeggingsMeta.addAttributeModifier(Attribute.GENERIC_ARMOR, i_goldLeggingsArmor);

            AttributeModifier i_goldLeggingsSpeed = new AttributeModifier(UUID.fromString("95c4f950-1631-4cc4-9f67-f45d8f088c73"),
                    "generic.movementSpeed", -0.02, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.LEGS);
            i_goldLeggingsMeta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, i_goldLeggingsSpeed);

            i_goldLeggingsMeta.displayName(Utils.getColoredString(lang.golden_greaves));
            i_goldLeggingsMeta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 4, true);

            i_goldLeggings.setItemMeta(i_goldLeggingsMeta);
            return i_goldLeggings;
        } else if (item == Item.GOLDEN_CROWN) {
            ItemStack i_goldHelmet = new ItemStack(Item.GOLDEN_CROWN.getMaterialType(), 1);
            ItemMeta i_goldHelmetMeta = i_goldHelmet.getItemMeta();

            AttributeModifier i_goldHelmetArmor = new AttributeModifier(UUID.fromString("95c4f950-1631-4cc4-9f67-f45d8f087c74"),
                    "generic.armor", 1, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
            i_goldHelmetMeta.addAttributeModifier(Attribute.GENERIC_ARMOR, i_goldHelmetArmor);

            AttributeModifier i_goldHelmetSpeed = new AttributeModifier(UUID.fromString("95c4f950-1631-4cc4-9f67-f45d8f088c74"),
                    "generic.movementSpeed", -0.0125, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.HEAD);
            i_goldHelmetMeta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, i_goldHelmetSpeed);

            i_goldHelmetMeta.displayName(Utils.getColoredString(lang.golden_crown));
            i_goldHelmetMeta.addEnchant(org.bukkit.enchantments.Enchantment.MENDING, 1, true);

            i_goldHelmet.setItemMeta(i_goldHelmetMeta);
            return i_goldHelmet;
        } else if (item == Item.IRON_BOOTS) {
            ItemStack i_ironBoots = new ItemStack(Item.IRON_BOOTS.getMaterialType(), 1);
            ItemMeta i_ironBootsMeta = i_ironBoots.getItemMeta();

            AttributeModifier i_ironBootsArmor = new AttributeModifier(UUID.fromString("95c4f950-1631-4cc4-9f67-f45d8f087c75"),
                    "generic.armor", 2, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
            i_ironBootsMeta.addAttributeModifier(Attribute.GENERIC_ARMOR, i_ironBootsArmor);
            AttributeModifier i_ironBootsSpeed = new AttributeModifier(UUID.fromString("95c4f950-1631-4cc4-9f67-f45d8f087c76"),
                    "generic.movementSpeed", -0.02, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.FEET);
            i_ironBootsMeta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, i_ironBootsSpeed);

            i_ironBoots.setItemMeta(i_ironBootsMeta);
            return i_ironBoots;
        } else if (item == Item.IRON_CHESTPLATE) {
            ItemStack i_ironChestplate = new ItemStack(Item.IRON_CHESTPLATE.getMaterialType(), 1);
            ItemMeta i_ironChestplateMeta = i_ironChestplate.getItemMeta();

            AttributeModifier i_ironChestMove = new AttributeModifier(UUID.fromString("95c4f950-1631-4cc4-9f67-f45d8f087c77"),
                    "generic.movementSpeed", -0.03, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.CHEST);
            i_ironChestplateMeta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, i_ironChestMove);

            AttributeModifier i_ironChestArmor = new AttributeModifier(UUID.fromString("95c4f950-1631-4cc4-9f67-f45d8f087c78"),
                    "generic.armor", 6, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
            i_ironChestplateMeta.addAttributeModifier(Attribute.GENERIC_ARMOR, i_ironChestArmor);

            i_ironChestplate.setItemMeta(i_ironChestplateMeta);
            return i_ironChestplate;
        } else if (item == Item.IRON_LEGGINGS) {
            ItemStack i_ironLeggings = new ItemStack(Item.IRON_LEGGINGS.getMaterialType(), 1);
            ItemMeta i_ironLeggingsMeta = i_ironLeggings.getItemMeta();

            AttributeModifier i_ironLeggingsArmor = new AttributeModifier(UUID.fromString("95c4f950-1631-4cc4-9f67-f45d8f087c79"),
                    "generic.armor", 5, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
            i_ironLeggingsMeta.addAttributeModifier(Attribute.GENERIC_ARMOR, i_ironLeggingsArmor);

            AttributeModifier i_ironLeggingsSpeed = new AttributeModifier(UUID.fromString("95c4f950-1631-4cc4-9f67-f45d8f087c80"),
                    "generic.movementSpeed", -0.03, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.LEGS);
            i_ironLeggingsMeta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, i_ironLeggingsSpeed);

            i_ironLeggings.setItemMeta(i_ironLeggingsMeta);
            return i_ironLeggings;
        } else if (item == Item.IRON_HELMET) {
            ItemStack i_ironHelmet = new ItemStack(Item.IRON_HELMET.getMaterialType(), 1);
            ItemMeta i_ironHelmetMeta = i_ironHelmet.getItemMeta();

            AttributeModifier i_ironHelmetArmor = new AttributeModifier(UUID.fromString("95c4f950-1631-4cc4-9f67-f45d8f087c81"),
                    "generic.armor", 2, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
            i_ironHelmetMeta.addAttributeModifier(Attribute.GENERIC_ARMOR, i_ironHelmetArmor);

            AttributeModifier i_ironHelmetSpeed = new AttributeModifier(UUID.fromString("95c4f950-1631-4cc4-9f67-f45d8f087c82"),
                    "generic.movementSpeed", -0.02, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.HEAD);
            i_ironHelmetMeta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, i_ironHelmetSpeed);

            i_ironHelmet.setItemMeta(i_ironHelmetMeta);
            return i_ironHelmet;
        } else if (item == Item.DIAMOND_BOOTS) {
            ItemStack i_diamondBoots = new ItemStack(Item.DIAMOND_BOOTS.getMaterialType(), 1);
            ItemMeta i_diamondBootsMeta = i_diamondBoots.getItemMeta();

            AttributeModifier i_diamondBootsArmor = new AttributeModifier(UUID.fromString("95c4f950-1631-4cc4-9f67-f45d8f087c83"),
                    "generic.armor", 3, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
            i_diamondBootsMeta.addAttributeModifier(Attribute.GENERIC_ARMOR, i_diamondBootsArmor);

            AttributeModifier i_diamondBootsSpeed = new AttributeModifier(UUID.fromString("95c4f950-1631-4cc4-9f67-f45d8f087c84"),
                    "generic.movementSpeed", -0.02, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.FEET);
            i_diamondBootsMeta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, i_diamondBootsSpeed);

            i_diamondBoots.setItemMeta(i_diamondBootsMeta);
            return i_diamondBoots;
        } else if (item == Item.DIAMOND_CHESTPLATE) {
            ItemStack i_diamondChestplate = new ItemStack(Item.DIAMOND_CHESTPLATE.getMaterialType(), 1);
            ItemMeta i_diamondChestplateMeta = i_diamondChestplate.getItemMeta();

            AttributeModifier i_diamondChestArmor = new AttributeModifier(UUID.fromString("95c4f950-1631-4cc4-9f67-f45d8f087c85"),
                    "generic.armor", 8, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
            i_diamondChestplateMeta.addAttributeModifier(Attribute.GENERIC_ARMOR, i_diamondChestArmor);

            AttributeModifier i_diamondChestSpeed = new AttributeModifier(UUID.fromString("95c4f950-1631-4cc4-9f67-f45d8f087c86"),
                    "generic.movementSpeed", -0.03, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.CHEST);
            i_diamondChestplateMeta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, i_diamondChestSpeed);

            i_diamondChestplate.setItemMeta(i_diamondChestplateMeta);
            return i_diamondChestplate;
        } else if (item == Item.DIAMOND_LEGGINGS) {
            ItemStack i_diamondLeggings = new ItemStack(Item.DIAMOND_LEGGINGS.getMaterialType(), 1);
            ItemMeta i_diamondLeggingsMeta = i_diamondLeggings.getItemMeta();

            AttributeModifier i_diamondLegArmor = new AttributeModifier(UUID.fromString("95c4f950-1631-4cc4-9f67-f45d8f087c87"),
                    "generic.armor", 6, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
            i_diamondLeggingsMeta.addAttributeModifier(Attribute.GENERIC_ARMOR, i_diamondLegArmor);

            AttributeModifier i_diamondLegSpeed = new AttributeModifier(UUID.fromString("95c4f950-1631-4cc4-9f67-f45d8f087c88"),
                    "generic.movementSpeed", -0.03, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.LEGS);
            i_diamondLeggingsMeta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, i_diamondLegSpeed);

            i_diamondLeggings.setItemMeta(i_diamondLeggingsMeta);
            return i_diamondLeggings;
        } else if (item == Item.DIAMOND_HELMET) {
            ItemStack i_diamondHelmet = new ItemStack(Item.DIAMOND_HELMET.getMaterialType(), 1);
            ItemMeta i_diamondHelmetMeta = i_diamondHelmet.getItemMeta();

            AttributeModifier i_diamondHelmetArmor = new AttributeModifier(UUID.fromString("95c4f950-1631-4cc4-9f67-f45d8f087c89"),
                    "generic.armor", 3, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
            i_diamondHelmetMeta.addAttributeModifier(Attribute.GENERIC_ARMOR, i_diamondHelmetArmor);

            AttributeModifier i_diamondHelmetSpeed = new AttributeModifier(UUID.fromString("95c4f950-1631-4cc4-9f67-f45d8f087c90"),
                    "generic.movementSpeed", -0.02, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.HEAD);
            i_diamondHelmetMeta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, i_diamondHelmetSpeed);

            i_diamondHelmet.setItemMeta(i_diamondHelmetMeta);
            return i_diamondHelmet;
        } else if (item == Item.RECURVE_BOW) {
            ItemStack i_recurveBow = new ItemStack(Item.RECURVE_BOW.getMaterialType(), 1);

            ItemMeta recurveBowMeta = i_recurveBow.getItemMeta();
            recurveBowMeta.setCustomModelData(Item.RECURVE_BOW.getModelData());
            recurveBowMeta.displayName(Utils.getColoredString(lang.recurved_bow));
            recurveBowMeta.lore(Collections.singletonList(Utils.getColoredString(lang.recurved).color(TextColor.color(0xCBC3E3))));
            recurveBowMeta.addEnchant(Enchantment.ARROW_KNOCKBACK, 1, true);
            i_recurveBow.setItemMeta(recurveBowMeta);
            return i_recurveBow;
        } else if (item == Item.RECURVE_CROSSBOW) {
            ItemStack recurveCrossbow = new ItemStack(Item.RECURVE_CROSSBOW.getMaterialType(), 1);
            ItemMeta recurveCrossbowMeta = recurveCrossbow.getItemMeta();
            recurveCrossbowMeta.setCustomModelData(Item.RECURVE_BOW.getModelData());
            recurveCrossbowMeta.displayName(Utils.getColoredString(lang.recurved_crossbow));
            recurveCrossbowMeta.lore(Collections.singletonList(Utils.getColoredString(lang.recurved)));
            recurveCrossbowMeta.addEnchant(Enchantment.ARROW_KNOCKBACK, 1, true);
            recurveCrossbow.setItemMeta(recurveCrossbowMeta);
            return recurveCrossbow;
        } else if (item == Item.DIRTY_WATER) {
            ItemStack dirty_water = new ItemStack(Item.CLEAN_WATER.getMaterialType());
            ItemMeta dirtyMeta = dirty_water.getItemMeta();
            dirtyMeta.setCustomModelData(Item.DIRTY_WATER.getModelData());
            ((PotionMeta) dirtyMeta).setBasePotionData(new PotionData(PotionType.WATER));
            ((PotionMeta) dirtyMeta).setColor(Color.fromRGB(lang.dirty_water_color));
            dirtyMeta.displayName(Utils.getColoredString(lang.dirty_water));
            dirtyMeta.lore(Collections.singletonList(Utils.getColoredString(lang.dirty_water_lore)));
            dirtyMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
            dirty_water.setItemMeta(dirtyMeta);
            return dirty_water;
        } else if (item == Item.CLEAN_WATER) {
            ItemStack clean_water = new ItemStack(Item.CLEAN_WATER.getMaterialType());
            ItemMeta cleanMeta = clean_water.getItemMeta();
            cleanMeta.setCustomModelData(Item.CLEAN_WATER.getModelData());
            ((PotionMeta) cleanMeta).setBasePotionData(new PotionData(PotionType.WATER));
            ((PotionMeta) cleanMeta).setColor(Color.fromRGB(lang.clean_water_color));
            cleanMeta.displayName(Utils.getColoredString(lang.clean_water));
            cleanMeta.lore(Collections.singletonList(Utils.getColoredString(lang.clean_water_lore)));
            cleanMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
            clean_water.setItemMeta(cleanMeta);
            return clean_water;
        } else if (item == Item.PURIFIED_WATER) {
            ItemStack purified_water = new ItemStack(Item.PURIFIED_WATER.getMaterialType());
            ItemMeta meta = purified_water.getItemMeta();
            meta.setCustomModelData(Item.PURIFIED_WATER.getModelData());
            ((PotionMeta) meta).setBasePotionData(new PotionData(PotionType.WATER));
            ((PotionMeta) meta).setColor(Color.fromRGB(lang.purified_water_color));
            meta.displayName(Utils.getColoredString(lang.purified_water));
            meta.lore(Collections.singletonList(Utils.getColoredString(lang.purified_water_lore)));
            meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
            purified_water.setItemMeta(meta);
            return purified_water;
        } else if (item == Item.WATER_BOWL) {
            ItemStack water_bowl = new ItemStack(Item.WATER_BOWL.getMaterialType());
            PotionMeta water_bowlMeta = ((PotionMeta) water_bowl.getItemMeta());
            water_bowlMeta.setBasePotionData(new PotionData(PotionType.WATER));
            water_bowlMeta.setCustomModelData(Item.WATER_BOWL.getModelData());
            water_bowlMeta.displayName(Utils.getColoredString(lang.water_bowl));
            water_bowl.setItemMeta(water_bowlMeta);
            return water_bowl;
        } else if (item == Item.CAMPFIRE) {
            ItemStack campfire = new ItemStack(Item.CAMPFIRE.getMaterialType());
            ItemMeta campfireMeta = campfire.getItemMeta();
            campfireMeta.displayName(Utils.getColoredString(lang.campfire_name));
            String[] lorelist = lang.campfire_lore.split("\\|\\|");
            List<Component> lore = new ArrayList<>();
            for (String l : lorelist) {
                lore.add(Utils.getColoredString(l));
            }
            campfireMeta.lore(lore);
            campfireMeta.setCustomModelData(Item.CAMPFIRE.getModelData());
            BlockData data = Material.CAMPFIRE.createBlockData();
            ((Campfire) data).setLit(false);
            ((BlockDataMeta) campfireMeta).setBlockData(data);
            campfire.setItemMeta(campfireMeta);
            return campfire;
        } else if (item == Item.STONE_SICKLE) {
            ItemStack stone_sickle = new ItemStack(Item.STONE_SICKLE.getMaterialType());
            ItemMeta stone_sickleMeta = stone_sickle.getItemMeta();
            stone_sickleMeta.setCustomModelData(Item.STONE_SICKLE.getModelData());
            stone_sickleMeta.displayName(Utils.getColoredString(lang.stone_sickle));
            stone_sickle.setItemMeta(stone_sickleMeta);
            return stone_sickle;
        } else if (item == Item.IRON_SICKLE) {
            ItemStack iron_sickle_new = new ItemStack(Item.IRON_SICKLE.getMaterialType());
            ItemMeta iron_sickle_new_meta = iron_sickle_new.getItemMeta();
            iron_sickle_new_meta.setCustomModelData(Item.IRON_SICKLE.getModelData());
            iron_sickle_new_meta.displayName(Utils.getColoredString(lang.iron_sickle));
            iron_sickle_new.setItemMeta(iron_sickle_new_meta);
            return iron_sickle_new;
        } else if (item == Item.FLINT_SICKLE) {
            ItemStack flint_sickle = new ItemStack(Item.FLINT_SICKLE.getMaterialType());
            ItemMeta flint_sickle_meta = flint_sickle.getItemMeta();
            flint_sickle_meta.setCustomModelData(Item.FLINT_SICKLE.getModelData());
            flint_sickle_meta.displayName(Utils.getColoredString(lang.flint_sickle));
            flint_sickle.setItemMeta(flint_sickle_meta);
            return flint_sickle;
        } else if (item == Item.DIAMOND_SICKLE) {
            ItemStack diamond_sickle = new ItemStack(Item.DIAMOND_SICKLE.getMaterialType());
            ItemMeta diamond_sickle_meta = diamond_sickle.getItemMeta();
            diamond_sickle_meta.setCustomModelData(Item.DIAMOND_SICKLE.getModelData());
            diamond_sickle_meta.displayName(Utils.getColoredString(lang.diamond_sickle));
            diamond_sickle.setItemMeta(diamond_sickle_meta);
            return diamond_sickle;
        } else if (item == Item.GRAPPLING_HOOK) {
            ItemStack grappling_hook = new ItemStack(Item.GRAPPLING_HOOK.getMaterialType());
            ItemMeta grappling_meta = grappling_hook.getItemMeta();
            grappling_meta.displayName(Utils.getColoredString(lang.grappling_hook));
            grappling_meta.setCustomModelData(Item.GRAPPLING_HOOK.getModelData());
            grappling_hook.setItemMeta(grappling_meta);
            return grappling_hook;
        } else if (item == Item.COFFEE) {
            ItemStack coffee = new ItemStack(Item.COFFEE.getMaterialType());
            ItemMeta coffee_meta = coffee.getItemMeta();
            coffee_meta.setCustomModelData(Item.COFFEE.getModelData());
            ((PotionMeta) coffee_meta).setBasePotionData(new PotionData(PotionType.WATER));
            ((PotionMeta) coffee_meta).setColor(Color.fromRGB(lang.coffee_color));
            coffee_meta.displayName(Utils.getColoredString(lang.coffee_name));
            coffee_meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
            coffee.setItemMeta(coffee_meta);
            return coffee;
        } else if (item == Item.HOT_MILK) {
            ItemStack hot_milk = new ItemStack(Item.HOT_MILK.getMaterialType());
            ItemMeta hot_milk_meta = hot_milk.getItemMeta();
            hot_milk_meta.setCustomModelData(Item.HOT_MILK.getModelData());
            ((PotionMeta) hot_milk_meta).setBasePotionData(new PotionData(PotionType.WATER));
            ((PotionMeta) hot_milk_meta).setColor(Color.fromRGB(lang.hot_milk_color));
            hot_milk_meta.displayName(Utils.getColoredString(lang.hot_milk_name));
            hot_milk_meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
            hot_milk.setItemMeta(hot_milk_meta);
            return hot_milk;
        } else if (item == Item.COLD_MILK) {
            ItemStack cold_milk = new ItemStack(Item.COLD_MILK.getMaterialType());
            ItemMeta cold_milk_meta = cold_milk.getItemMeta();
            cold_milk_meta.setCustomModelData(Item.COLD_MILK.getModelData());
            ((PotionMeta) cold_milk_meta).setBasePotionData(new PotionData(PotionType.WATER));
            ((PotionMeta) cold_milk_meta).setColor(Color.fromRGB(lang.cold_milk_color));
            cold_milk_meta.displayName(Utils.getColoredString(lang.cold_milk_name));
            cold_milk_meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
            cold_milk.setItemMeta(cold_milk_meta);
            return cold_milk;
        } else if (item == Item.COFFEE_BEAN) {
            ItemStack coffee_bean = new ItemStack(Item.COFFEE_BEAN.getMaterialType());
            ItemMeta coffee_bean_meta = coffee_bean.getItemMeta();
            coffee_bean_meta.setCustomModelData(Item.COFFEE_BEAN.getModelData());
            coffee_bean_meta.displayName(Utils.getColoredString(lang.coffee_bean_name));
            coffee_bean.setItemMeta(coffee_bean_meta);
            return coffee_bean;
        } else if (item == Item.BREEDING_EGG) {
            ItemStack breeding_egg = new ItemStack(Item.BREEDING_EGG.getMaterialType());
            ItemMeta breeding_egg_meta = breeding_egg.getItemMeta();
            breeding_egg_meta.setCustomModelData(Item.BREEDING_EGG.getModelData());
            breeding_egg_meta.displayName(Utils.getColoredString(lang.breeding_egg_name));
            breeding_egg.setItemMeta(breeding_egg_meta);
            return breeding_egg;
        } else if (item == Item.COMPASS) {
            ItemStack compass = new ItemStack(Item.COMPASS.getMaterialType());
            ItemMeta compass_meta = compass.getItemMeta();
            List<Component> compass_lore = new ArrayList<>();
            for (int i = 0; i < lang.compass_lore.size(); i++) {
                compass_lore.add(Utils.getColoredString(lang.compass_lore.get(i)));
            }
            compass_meta.lore(compass_lore);
            compass.setItemMeta(compass_meta);
            return compass;
        } else if (item == Item.PERSISTENT_TORCH) {
            // TODO Experimental
            ItemStack persistent_torch = new ItemStack(Item.PERSISTENT_TORCH.getMaterialType());
            ItemMeta p_torch_meta = persistent_torch.getItemMeta();
            p_torch_meta.setCustomModelData(Item.PERSISTENT_TORCH.getModelData());
            p_torch_meta.lore(Collections.singletonList(Component.text("Persistent").color(TextColor.color(0x00FFFF))));
            persistent_torch.setItemMeta(p_torch_meta);
            return persistent_torch;
        } else if (item == Item.BEEKEEPER_HELMET) {
            ItemStack beeHelmet = new ItemStack(Item.BEEKEEPER_HELMET.getMaterialType());
            ItemMeta bhMeta = beeHelmet.getItemMeta();
            bhMeta.setCustomModelData(Item.BEEKEEPER_HELMET.getModelData());
            bhMeta.displayName(Utils.getColoredString(lang.bee_helmet_name));
            bhMeta.lore(Collections.singletonList(Utils.getColoredString(lang.bee_suit_lore)));
            ((LeatherArmorMeta) bhMeta).setColor(Color.WHITE);
            bhMeta.addItemFlags(ItemFlag.HIDE_DYE);
            beeHelmet.setItemMeta(bhMeta);
            return beeHelmet;
        } else if (item == Item.BEEKEEPER_CHESTPLATE) {
            ItemStack beeChest = new ItemStack(Item.BEEKEEPER_CHESTPLATE.getMaterialType());
            ItemMeta bcMeta = beeChest.getItemMeta();
            bcMeta.setCustomModelData(Item.BEEKEEPER_CHESTPLATE.getModelData());
            bcMeta.displayName(Utils.getColoredString(lang.bee_chest_name));
            bcMeta.lore(Collections.singletonList(Utils.getColoredString(lang.bee_suit_lore)));
            ((LeatherArmorMeta) bcMeta).setColor(Color.WHITE);
            bcMeta.addItemFlags(ItemFlag.HIDE_DYE);
            beeChest.setItemMeta(bcMeta);
            return beeChest;
        } else if (item == Item.BEEKEEPER_LEGGINGS) {
            ItemStack beeLegs = new ItemStack(Item.BEEKEEPER_LEGGINGS.getMaterialType());
            ItemMeta blMeta = beeLegs.getItemMeta();
            blMeta.setCustomModelData(Item.BEEKEEPER_LEGGINGS.getModelData());
            blMeta.displayName(Utils.getColoredString(lang.bee_legs_name));
            blMeta.lore(Collections.singletonList(Utils.getColoredString(lang.bee_suit_lore)));
            ((LeatherArmorMeta) blMeta).setColor(Color.WHITE);
            blMeta.addItemFlags(ItemFlag.HIDE_DYE);
            beeLegs.setItemMeta(blMeta);
            return beeLegs;
        } else if (item == Item.BEEKEEPER_BOOTS) {
            ItemStack beeBoots = new ItemStack(Item.BEEKEEPER_BOOTS.getMaterialType());
            ItemMeta bbMeta = beeBoots.getItemMeta();
            bbMeta.setCustomModelData(Item.BEEKEEPER_BOOTS.getModelData());
            bbMeta.displayName(Utils.getColoredString(lang.bee_boots_name));
            bbMeta.lore(Collections.singletonList(Utils.getColoredString(lang.bee_suit_lore)));
            ((LeatherArmorMeta) bbMeta).setColor(Color.WHITE);
            bbMeta.addItemFlags(ItemFlag.HIDE_DYE);
            beeBoots.setItemMeta(bbMeta);
            return beeBoots;
        } else if (item == Item.SUSPICIOUS_MEAT) {
            ItemStack suspicious_meat = new ItemStack(Item.SUSPICIOUS_MEAT.getMaterialType());
            SuspiciousStewMeta suspicious_meat_meta = ((SuspiciousStewMeta) suspicious_meat.getItemMeta());
            suspicious_meat_meta.setCustomModelData(Item.SUSPICIOUS_MEAT.getModelData());
            suspicious_meat_meta.addCustomEffect(getRandomPotionEffect(), false);
            suspicious_meat_meta.displayName(Utils.getColoredString(lang.suspicious_meat));
            suspicious_meat.setItemMeta(suspicious_meat_meta);
            return suspicious_meat;
        } else if (item == Item.NETHERITE_HELMET) {
            ItemStack n_helmet = new ItemStack(Item.NETHERITE_HELMET.getMaterialType());
            ItemMeta n_h_meta = n_helmet.getItemMeta();

            AttributeModifier n_h_armor = new AttributeModifier(UUID.fromString("95c4f950-1631-4cc4-9f67-f45d8f086c91"),
                    "generic.armor", 3, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
            n_h_meta.addAttributeModifier(Attribute.GENERIC_ARMOR, n_h_armor);

            AttributeModifier n_h_tough = new AttributeModifier(UUID.fromString("95c4f950-1631-4cc4-9f67-f45d8f085c91"),
                    "generic.toughness", 3, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
            n_h_meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, n_h_tough);

            AttributeModifier n_h_knock = new AttributeModifier(UUID.fromString("95c4f950-1631-4cc4-9f67-f45d8f084c91"),
                    "generic.knock", 0.1, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
            n_h_meta.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, n_h_knock);

            AttributeModifier n_h_speed = new AttributeModifier(UUID.fromString("95c4f950-1631-4cc4-9f67-f45d8f087c91"),
                    "generic.movementSpeed", -0.02, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.HEAD);
            n_h_meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, n_h_speed);

            n_helmet.setItemMeta(n_h_meta);
            return n_helmet;
        } else if (item == Item.NETHERITE_CHESTPLATE) {
            ItemStack n_chest = new ItemStack(Item.NETHERITE_CHESTPLATE.getMaterialType());
            ItemMeta n_c_meta = n_chest.getItemMeta();

            AttributeModifier n_c_armor = new AttributeModifier(UUID.fromString("95c4f950-1631-4cc4-9f67-f45d8f086c92"),
                    "generic.armor", 8, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
            n_c_meta.addAttributeModifier(Attribute.GENERIC_ARMOR, n_c_armor);

            AttributeModifier n_c_tough = new AttributeModifier(UUID.fromString("95c4f950-1631-4cc4-9f67-f45d8f085c92"),
                    "generic.toughness", 3, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
            n_c_meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, n_c_tough);

            AttributeModifier n_c_knock = new AttributeModifier(UUID.fromString("95c4f950-1631-4cc4-9f67-f45d8f084c92"),
                    "generic.knock", 0.1, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
            n_c_meta.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, n_c_knock);

            AttributeModifier n_c_speed = new AttributeModifier(UUID.fromString("95c4f950-1631-4cc4-9f67-f45d8f087c92"),
                    "generic.movementSpeed", -0.02, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.HEAD);
            n_c_meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, n_c_speed);

            n_chest.setItemMeta(n_c_meta);
            return n_chest;
        } else if (item == Item.NETHERITE_LEGGINGS) {
            ItemStack n_leg = new ItemStack(Item.NETHERITE_LEGGINGS.getMaterialType());
            ItemMeta n_l_meta = n_leg.getItemMeta();

            AttributeModifier n_l_armor = new AttributeModifier(UUID.fromString("95c4f950-1631-4cc4-9f67-f45d8f086c93"),
                    "generic.armor", 6, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
            n_l_meta.addAttributeModifier(Attribute.GENERIC_ARMOR, n_l_armor);

            AttributeModifier n_l_tough = new AttributeModifier(UUID.fromString("95c4f950-1631-4cc4-9f67-f45d8f085c93"),
                    "generic.toughness", 3, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
            n_l_meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, n_l_tough);

            AttributeModifier n_l_knock = new AttributeModifier(UUID.fromString("95c4f950-1631-4cc4-9f67-f45d8f084c93"),
                    "generic.knock", 0.1, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
            n_l_meta.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, n_l_knock);

            AttributeModifier n_l_speed = new AttributeModifier(UUID.fromString("95c4f950-1631-4cc4-9f67-f45d8f087c93"),
                    "generic.movementSpeed", -0.02, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.HEAD);
            n_l_meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, n_l_speed);

            n_leg.setItemMeta(n_l_meta);
            return n_leg;
        } else if (item == Item.NETHERITE_BOOTS) {
            ItemStack n_boot = new ItemStack(Item.NETHERITE_BOOTS.getMaterialType());
            ItemMeta n_b_meta = n_boot.getItemMeta();

            AttributeModifier n_b_armor = new AttributeModifier(UUID.fromString("95c4f950-1631-4cc4-9f67-f45d8f086c94"),
                    "generic.armor", 3, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
            n_b_meta.addAttributeModifier(Attribute.GENERIC_ARMOR, n_b_armor);

            AttributeModifier n_b_tough = new AttributeModifier(UUID.fromString("95c4f950-1631-4cc4-9f67-f45d8f085c94"),
                    "generic.toughness", 3, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
            n_b_meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, n_b_tough);

            AttributeModifier n_b_knock = new AttributeModifier(UUID.fromString("95c4f950-1631-4cc4-9f67-f45d8f084c94"),
                    "generic.knock", 0.1, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
            n_b_meta.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, n_b_knock);

            AttributeModifier n_b_speed = new AttributeModifier(UUID.fromString("95c4f950-1631-4cc4-9f67-f45d8f087c94"),
                    "generic.movementSpeed", -0.02, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.HEAD);
            n_b_meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, n_b_speed);

            n_boot.setItemMeta(n_b_meta);
            return n_boot;
        } else if (item == Item.SNOW_BOOTS) {
            ItemStack snow_boots = new ItemStack(Item.SNOW_BOOTS.getMaterialType());
            ItemMeta snow_boots_meta = snow_boots.getItemMeta();
            if (snow_boots_meta instanceof LeatherArmorMeta) {
                ((LeatherArmorMeta) snow_boots_meta).setColor(Color.fromRGB(158, 201, 202));
            }
            snow_boots_meta.setCustomModelData(Item.SNOW_BOOTS.getModelData());
            snow_boots_meta.displayName(Utils.getColoredString(lang.snow_boots_name));
            snow_boots_meta.lore(Collections.singletonList(Utils.getColoredString(lang.snow_boots_lore)));
            snow_boots.setItemMeta(snow_boots_meta);

            return snow_boots;
        } else if (item == Item.RAIN_BOOTS) {
            ItemStack rain_boots = new ItemStack(Item.RAIN_BOOTS.getMaterialType());
            ItemMeta rain_boots_meta = rain_boots.getItemMeta();
            if (rain_boots_meta instanceof LeatherArmorMeta) {
                ((LeatherArmorMeta) rain_boots_meta).setColor(Color.fromRGB(214, 231, 3));
            }
            rain_boots_meta.setCustomModelData(Item.RAIN_BOOTS.getModelData());
            rain_boots_meta.displayName(Utils.getColoredString(lang.rain_boots_name));
            rain_boots_meta.lore(Collections.singletonList(Utils.getColoredString(lang.rain_boots_lore)));
            rain_boots.setItemMeta(rain_boots_meta);

            return rain_boots;
        } else {
            return new ItemStack(Material.AIR);
        }
    }

    /**
     * Compare an ItemStack with a custom {@link Item}
     * <p>
     * <b>NOTE:</b> Will only compare a custom item's {@link Material} and CustomModelData tag
     * </p>
     *
     * @param itemStack The ItemStack to check
     * @param type      The custom item enum to check
     * @return Whether these two items match or not
     */
    public static boolean compare(ItemStack itemStack, Item type) {
        if (itemStack.getType() == type.getMaterialType()) {
            if (itemStack.getItemMeta() != null && itemStack.getItemMeta().hasCustomModelData()) {
                return itemStack.getItemMeta().getCustomModelData() == type.getModelData();
            } else {
                return type.getModelData() == 0;
            }
        }
        return false;
    }

    /**
     * Compare an ItemStack with several custom {@link Item}
     *
     * @param itemStack The ItemStack to check
     * @param type      The custom item enums to check
     * @return Whether these items match or not
     */
    public static boolean compare(ItemStack itemStack, Item... type) {
        for (Item item : type) {
            if (compare(itemStack, item)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Apply the attributes from an {@link Item} to an existing ItemStack
     *
     * @param itemStack Current ItemStack to apply attributes to
     * @param items     Item to grab data from
     */
    public static void applyAttribute(ItemStack itemStack, Item items) {
        ItemStack from = items.getItem();
        ItemMeta metaTo = itemStack.getItemMeta();
        ItemMeta metaFrom = from.getItemMeta();
        Map<Enchantment, Integer> enchants = metaTo.getEnchants();
        for (Enchantment enchantment : enchants.keySet()) {
            metaFrom.addEnchant(enchantment, enchants.get(enchantment), true);
        }
        itemStack.setItemMeta(metaFrom);
    }

    private static final List<PotionEffectType> POTION_EFFECTS;

    static {
        POTION_EFFECTS = new ArrayList<>();
        // BAD
        POTION_EFFECTS.add(PotionEffectType.BAD_OMEN);
        POTION_EFFECTS.add(PotionEffectType.CONFUSION);
        POTION_EFFECTS.add(PotionEffectType.POISON);
        POTION_EFFECTS.add(PotionEffectType.UNLUCK);
        POTION_EFFECTS.add(PotionEffectType.HUNGER);
        POTION_EFFECTS.add(PotionEffectType.HARM);
        POTION_EFFECTS.add(PotionEffectType.SLOW);
        // GOOD
        POTION_EFFECTS.add(PotionEffectType.DOLPHINS_GRACE);
        POTION_EFFECTS.add(PotionEffectType.ABSORPTION);
        POTION_EFFECTS.add(PotionEffectType.FAST_DIGGING);
        POTION_EFFECTS.add(PotionEffectType.LUCK);
        POTION_EFFECTS.add(PotionEffectType.HEALTH_BOOST);
        POTION_EFFECTS.add(PotionEffectType.REGENERATION);
        POTION_EFFECTS.add(PotionEffectType.SPEED);
    }

    private static PotionEffect getRandomPotionEffect() {
        Random random = new Random();
        int randomEffect = random.nextInt(POTION_EFFECTS.size());
        int randomDuration = random.nextInt(200) + 200;
        return new PotionEffect(POTION_EFFECTS.get(randomEffect), randomDuration, 0);
    }

}
