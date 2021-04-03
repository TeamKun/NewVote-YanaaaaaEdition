package net.kunmc.lab.newvote;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.*;

//投票関係の結果生成
public class VoteResultLogic {

    /**
     * 各投票者の投票先をチャット欄に生成する。
     *
     * @param senders　リスト 投票者のリスト
     * @param receivers　リスト　投票先のリスト
     */
    static void sendVotingDestination(List<String> senders, List<String> receivers){
        //投票先の表示処理(全プレイヤーに表示)
        Bukkit.getOnlinePlayers().forEach(player -> {
            player.sendMessage(ChatColor.GOLD + "投票先を開示します。");
            player.sendMessage(ChatColor.AQUA + "Tabを押してスコアボードを確認してください。");
        });
        for (int i = 0; i < senders.size(); i++) {
            int num = i;
            Bukkit.getOnlinePlayers().forEach(player -> {
                ScoreBoardLogic.setVoteResult(senders.get(num),receivers.get(num));
            });
        }
    }
}
