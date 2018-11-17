package net.hotsmc.practice.scoreboard;

import net.hotsmc.practice.HotsPractice;
import net.hotsmc.practice.PracticePlayer;
import net.hotsmc.practice.game.games.Game;
import net.hotsmc.practice.game.games.GameState;
import net.hotsmc.practice.game.games.PartyFFAGame;
import net.hotsmc.practice.utility.TimeUtility;
import org.bukkit.ChatColor;
import org.bukkit.scoreboard.Team;

public class PartyGameFFAScoreboard extends PlayerScoreboard {


    public PartyGameFFAScoreboard(PracticePlayer practicePlayer) {
        super(practicePlayer);
    }

    @Override
    void onSetup() {
        Team line1 = scoreboard.registerNewTeam("Line1");
        line1.addEntry(ChatColor.WHITE.toString());
        line1.setPrefix("" + ChatColor.GRAY + ChatColor.STRIKETHROUGH + "------------");
        line1.setSuffix("" + ChatColor.GRAY + ChatColor.STRIKETHROUGH + "-----------");
        obj.getScore(ChatColor.WHITE.toString()).setScore(6);

        Team ladder = scoreboard.registerNewTeam("Ladder");
        ladder.addEntry(ChatColor.AQUA.toString());
        ladder.setPrefix("" + ChatColor.YELLOW + ChatColor.BOLD + "Ladder: ");
        ladder.setSuffix(""+ ChatColor.WHITE + HotsPractice.getGameManager().getPlayerOfGame(practicePlayer).getKitType());
        obj.getScore(ChatColor.AQUA.toString()).setScore(5);

        Team mode = scoreboard.registerNewTeam("Mode");
        mode.addEntry(getEntry("" + ChatColor.YELLOW + ChatColor.BOLD + "Party Fight:"));
        mode.setSuffix(getEntry(ChatColor.WHITE + " FFA"));
        obj.getScore(getEntry("" + ChatColor.YELLOW + ChatColor.BOLD + "Party Fight:")).setScore(4);

        PartyFFAGame ffa = (PartyFFAGame) HotsPractice.getGameManager().getPlayerOfGame(practicePlayer);

        Team alive = scoreboard.registerNewTeam("Alive");
        alive.addEntry(getEntry("" + ChatColor.YELLOW + ChatColor.BOLD + "Alive: " + ChatColor.WHITE));
        alive.setSuffix(getEntry("" + ffa.getParty().getAlivePlayers().size()));
        obj.getScore(getEntry("" + ChatColor.YELLOW + ChatColor.BOLD + "Alive: " + ChatColor.WHITE)).setScore(3);

        Team duration = scoreboard.registerNewTeam("Duration");
        duration.addEntry(ChatColor.BLUE.toString());
        Game game = HotsPractice.getGameManager().getPlayerOfGame(practicePlayer);
        if(game != null) {
            if (game.getState() == GameState.PreGame) {
                duration.setPrefix("" + ChatColor.YELLOW + ChatColor.BOLD + "Starting: ");
                duration.setSuffix("" + ChatColor.WHITE + game.getStartCooldown().getTimeLeft() + "s");
            } else {
                duration.setPrefix("" + ChatColor.YELLOW + ChatColor.BOLD + "Duration: ");
                duration.setSuffix("" + ChatColor.WHITE + TimeUtility.timeFormat(game.getTime()));
            }
        }
        obj.getScore(ChatColor.BLUE.toString()).setScore(2);

        Team line2 = scoreboard.registerNewTeam("Line2");
        line2.addEntry(ChatColor.STRIKETHROUGH.toString());
        line2.setPrefix("" + ChatColor.GRAY + ChatColor.STRIKETHROUGH + "------------");
        line2.setSuffix("" + ChatColor.GRAY + ChatColor.STRIKETHROUGH + "-----------");
        obj.getScore(ChatColor.STRIKETHROUGH.toString()).setScore(1);
    }

    @Override
    void onUpdate() {
        Game game = HotsPractice.getGameManager().getPlayerOfGame(practicePlayer);
        PartyFFAGame ffa = (PartyFFAGame) game;
        Team duration = scoreboard.getTeam("Duration");
        if(game != null) {
            if (game.getState() == GameState.PreGame) {
                duration.setPrefix("" + ChatColor.YELLOW + ChatColor.BOLD + "Starting: ");
                duration.setSuffix("" + ChatColor.WHITE + game.getStartCooldown().getTimeLeft() + "s");
            } else {
                duration.setPrefix("" + ChatColor.YELLOW + ChatColor.BOLD + "Duration: ");
                duration.setSuffix("" + ChatColor.WHITE + TimeUtility.timeFormat(game.getTime()));
            }
            scoreboard.getTeam("Alive").setSuffix(getEntry("" + ffa.getParty().getAlivePlayers().size()));
        }
    }
}