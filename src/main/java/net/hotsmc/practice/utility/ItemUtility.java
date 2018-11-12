package net.hotsmc.practice.utility;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionType;

import java.util.Arrays;
import java.util.List;

public class ItemUtility {
    public static ItemStack createItemStack(String name, Material mat, boolean unbreakable, String... lore) {
        ItemStack is = new ItemStack(mat);
        ItemMeta meta = is.getItemMeta();
        meta.setDisplayName(name);
        if (lore != null) {
            meta.setLore(Arrays.asList(lore));
        }
        if (unbreakable) {
            meta.spigot().setUnbreakable(true);
        }
        is.setItemMeta(meta);
        return is;
    }

    public static ItemStack createItemStack(String name, Material mat, boolean unbreakable, List<String> lore) {
        ItemStack is = new ItemStack(mat);
        ItemMeta meta = is.getItemMeta();
        meta.setDisplayName(name);
        if (lore != null) {
            meta.setLore(lore);
        }
        if (unbreakable) {
            meta.spigot().setUnbreakable(true);
        }
        is.setItemMeta(meta);
        return is;
    }

    public static ItemStack createItemStack(String name, Material mat, boolean unbreakable, int amount, String... lore) {
        ItemStack is = new ItemStack(mat);
        if (amount == 0) {
            amount = 1;
        }
        is.setAmount(amount);
        ItemMeta meta = is.getItemMeta();
        meta.setDisplayName(name);
        if (lore != null) {
            meta.setLore(Arrays.asList(lore));
        }
        if (unbreakable) {
            meta.spigot().setUnbreakable(true);
        }
        is.setItemMeta(meta);
        return is;
    }

    public static ItemStack createItemStack(String name, Material mat, boolean unbreakable, int amount, List<String> lore) {
        ItemStack is = new ItemStack(mat);
        if (amount == 0) {
            amount = 1;
        }
        is.setAmount(amount);
        ItemMeta meta = is.getItemMeta();
        meta.setDisplayName(name);
        meta.setLore(lore);
        if (unbreakable) {
            meta.spigot().setUnbreakable(true);
        }
        is.setItemMeta(meta);
        return is;
    }

    public static ItemStack createFlintAndSteel() {
        ItemStack is = new ItemStack(Material.FLINT_AND_STEEL);
        is.setDurability((short) 61);
        ItemMeta meta = is.getItemMeta();
        meta.setDisplayName(ChatColor.YELLOW + "Flint and Steel");
        is.setItemMeta(meta);
        return is;
    }

    public static ItemStack createPlayerSkull(String displayName, String... lore){
        ItemStack myAwesomeSkull = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        ItemMeta meta = myAwesomeSkull.getItemMeta();
        meta.setDisplayName(displayName);
        if (lore != null) {
            meta.setLore(Arrays.asList(lore));
        }
        myAwesomeSkull.setItemMeta(meta);
        return myAwesomeSkull;
    }

    public static ItemStack addLore(ItemStack itemStack, String... lore) {
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setLore(Arrays.asList(lore));
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public static ItemStack addEnchant(ItemStack itemStack, Enchantment enchant, int level) {
        ItemMeta meta = itemStack.getItemMeta();
        meta.addEnchant(enchant, level, true);
        itemStack.setItemMeta(meta);
        return itemStack;
    }

    public static ItemStack createFish(String name, int amount, int type, String... lore) {
        if (amount == 0) {
            amount = 1;
        }
        ItemStack itemStack = new ItemStack(Material.RAW_FISH, amount, (short) type);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(name);
        if (lore != null) {
            itemMeta.setLore(Arrays.asList(lore));
        }
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public static ItemStack createFish(String name, int amount, int type, List<String> lore) {
        if (amount == 0) {
            amount = 1;
        }
        ItemStack itemStack = new ItemStack(Material.RAW_FISH, amount, (short) type);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(name);
        if (lore != null) {
            itemMeta.setLore(lore);
        }
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public static ItemStack createEnchGapple(String name, int amount, String... lore) {
        if (amount == 0) {
            amount = 1;
        }
        ItemStack itemStack = new ItemStack(Material.GOLDEN_APPLE, amount, (short) 1);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(name);
        if (lore != null) {
            itemMeta.setLore(Arrays.asList(lore));
        }
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public static ItemStack createEnchGapple(String name, int amount, List<String> lore) {
        if (amount == 0) {
            amount = 1;
        }
        ItemStack itemStack = new ItemStack(Material.GOLDEN_APPLE, amount, (short) 1);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(name);
        if (lore != null) {
            itemMeta.setLore(lore);
        }
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public static ItemStack createSplashPotion(String name, int amount, PotionType type, String... lore) {
        if (amount == 0) {
            amount = 1;
        }
        ItemStack item = new ItemStack(Material.POTION, amount);
        Potion pot = new Potion(type);
        pot.setSplash(true);
        pot.apply(item);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(name);
        if(lore != null){
            itemMeta.setLore(Arrays.asList(lore));
        }
        item.setItemMeta(itemMeta);
        return item;
    }

    public static ItemStack createSplashPotion(String name, int amount, PotionType type, List<String> lore) {
        if (amount == 0) {
            amount = 1;
        }
        ItemStack item = new ItemStack(Material.POTION, amount);
        Potion pot = new Potion(type);
        pot.setSplash(true);
        pot.apply(item);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(name);
        if(lore != null){
            itemMeta.setLore(lore);
        }
        item.setItemMeta(itemMeta);
        return item;
    }

    public static ItemStack createWool(String name, int amount, int type, String... lore) {
        if (amount == 0) {
            amount = 1;
        }
        ItemStack itemStack = new ItemStack(Material.WOOL, amount, (short) type);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(name);
        if (lore != null) {
            itemMeta.setLore(Arrays.asList(lore));
        }
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public static ItemStack createWool(String name, int amount, int type, List<String> lore) {
        if (amount == 0) {
            amount = 1;
        }
        ItemStack itemStack = new ItemStack(Material.WOOL, amount, (short) type);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(name);
        if (lore != null) {
            itemMeta.setLore(lore);
        }
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public static ItemStack createPlayerNameSkull(String playerName, String displayName, String... lore){
        ItemStack myAwesomeSkull = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        SkullMeta myAwesomeSkullMeta = (SkullMeta) myAwesomeSkull.getItemMeta();
        myAwesomeSkullMeta.setOwner(playerName);
        myAwesomeSkull.setItemMeta(myAwesomeSkullMeta);
        ItemMeta meta = myAwesomeSkull.getItemMeta();
        meta.setDisplayName(displayName);
        if (lore != null) {
            meta.setLore(Arrays.asList(lore));
        }
        myAwesomeSkull.setItemMeta(meta);
        return myAwesomeSkull;
    }
}
