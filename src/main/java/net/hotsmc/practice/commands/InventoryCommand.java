package net.hotsmc.practice.commands;

import net.hotsmc.practice.HotsPractice;
import net.hotsmc.practice.inventory.InventoryDataManager;
import net.hotsmc.practice.inventory.PlayerInventory;
import net.hotsmc.practice.utility.ChatUtility;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class InventoryCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            if(args.length == 1){
                String uuid = args[0];
                InventoryDataManager inventoryDataManager = HotsPractice.getInventoryDataManager();
                PlayerInventory inventory = inventoryDataManager.getPlayerInventoryByUUID(uuid);
                if(inventory == null){
                    ChatUtility.sendMessage(player, ChatColor.RED + "Not found inventory data");
                }else{
                    inventoryDataManager.getPlayerInventoryByUUID(uuid).openMenu(player, 45);
                }
            }
        }
        return true;
    }
}