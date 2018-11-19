package net.hotsmc.practice.scoreboard;

import net.hotsmc.practice.PracticePlayer;
import net.hotsmc.practice.HotsPractice;
import net.hotsmc.practice.game.games.GameState;
import net.hotsmc.practice.game.games.Game;
import net.hotsmc.practice.utility.TimeUtility;
import org.bukkit.ChatColor;
import org.bukkit.scoreboard.Team;

public class PartyDuelGameScoreboard extends PlayerScoreboard {

    public PartyDuelGameScoreboard(PracticePlayer practicePlayer) {
        super(practicePlayer);
    }

    @Override
    void onSetup() {
        Team line1 = scoreboard.registerNewTeam("Line1");
        line1.addEntry(ChatColor.WHITE.toString());
        line1.setPrefix("" + ChatColor.GRAY + ChatColor.STRIKETHROUGH + "------------");
        line1.setSuffix("" + ChatColor.GRAY + ChatColor.STRIKETHROUGH + "-----------");
        obj.getScore(ChatColor.WHITE.toString()).setScore(7);

        Team ladder = scoreboard.registerNewTeam("Ladder");
        ladder.addEntry(ChatColor.AQUA.toString());
        ladder.setPrefix("" + ChatColor.YELLOW + ChatColor.BOLD + "Ladder: ");
        ladder.setSuffix(""+ ChatColor.WHITE + HotsPractice.getGameManager().getPlayerOfGame(practicePlayer).getKitType());
        obj.getScore(ChatColor.AQUA.toString()).setScore(6);

        Team opponentParty = scoreboard.registerNewTeam("OpponentParty");
        opponentParty.addEntry(getEntry("" + ChatColor.YELLOW + ChatColor.BOLD + "Party: "));
        opponentParty.setPrefix(getEntry("" + ChatColor.YELLOW + ChatColor.BOLD + "Opponent "));
        opponentParty.setSuffix(getEntry(practicePlayer.getOpponent()));
        obj.getScore(getEntry("" + ChatColor.YELLOW + ChatColor.BOLD + "Party: ")).setScore(5);

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
        obj.getScore(ChatColor.BLUE.toString()).setScore(4);

        Team yourPing = scoreboard.registerNewTeam("YourPing");
        yourPing.addEntry(ChatColor.MAGIC.toString());
        yourPing.setPrefix("" + ChatColor.YELLOW + ChatColor.BOLD + "Your Ping: ");
        yourPing.setSuffix("" + ChatColor.WHITE + practicePlayer.getPing() + "ms");
        obj.getScore(ChatColor.MAGIC.toString()).setScore(2);

        Team line2 = scoreboard.registerNewTeam("Line2");
        line2.addEntry(ChatColor.STRIKETHROUGH.toString());
        line2.setPrefix("" + ChatColor.GRAY + ChatColor.STRIKETHROUGH + "------------");
        line2.setSuffix("" + ChatColor.GRAY + ChatColor.STRIKETHROUGH + "-----------");
        obj.getScore(ChatColor.STRIKETHROUGH.toString()).setScore(1);
    }

    @Override
    void onUpdate() {
        Game game = HotsPractice.getGameManager().getPlayerOfGame(practicePlayer);
        Team duration = scoreboard.getTeam("Duration");
        if(game != null) {
            if (game.getState() == GameState.PreGame) {
                duration.setPrefix("" + ChatColor.YELLOW + ChatColor.BOLD + "Starting: ");
                duration.setSuffix("" + ChatColor.WHITE + game.getStartCooldown().getTimeLeft() + "s");
            } else {
                duration.setPrefix("" + ChatColor.YELLOW + ChatColor.BOLD + "Duration: ");
                duration.setSuffix("" + ChatColor.WHITE + TimeUtility.timeFormat(game.getTime()));
            }
        }
        scoreboard.getTeam("YourPing").setSuffix("" + ChatColor.WHITE + practicePlayer.getPing() + "ms");
    }
}
