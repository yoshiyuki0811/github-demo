package plugin.sample;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.World;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.checkerframework.checker.units.qual.C;


public final class Main extends JavaPlugin implements Listener {

  private int count ;

  @Override

  public void onEnable() {
    Bukkit.getPluginManager().registerEvents(this, this);
  }



  /**
   * プレイヤーがスニークを開始/終了する際に起動されるイベントハンドラ。
   *
   * @param e イベント
   */
  @EventHandler
  public void onPlayerToggleSneak(PlayerToggleSneakEvent e) throws IOException {
    // イベント発生時のプレイヤーやワールドなどの情報を変数に持つ。
    Player player = e.getPlayer();
    World world = player.getWorld();

    List<Color> colorList = List.of(Color.RED,Color.BLUE,Color.WHITE,Color.BLACK);
if (count % 2 ==0){
  for (Color color :colorList) {
    // 花火オブジェクトをプレイヤーのロケーション地点に対して出現させる。
    firework = world.spawn(player.getLocation(), Firework.clas Fireworks);

    // 花火オブジェクトが持つメタ情報を取得。
    FireworkMeta fireworkMeta = firework.getFireworkMeta();

    // メタ情報に対して設定を追加したり、値の上書きを行う。
    // 今回は青色で星型の花火を打ち上げる。
    fireworkMeta.addEffect(
        FireworkEffect.builder()
            .withColor(Color.RED)
            .withColor(Color.BLACK)
            .with(Type.BALL_LARGE)
            .withFlicker()
            .build());
    fireworkMeta.setPower(2 + 2 * 8);

    // 追加した情報で再設定する。
    firework.setFireworkMeta(fireworkMeta);
  }
  Path path = Path.of("firework.txt");
  Files.writeString(path,"たーまやー！");
  player.sendMessage(Files.readString(path));
}
    count++ ;
  }
@EventHandler
  public void onPlayerBedEnter(PlayerBedEnterEvent e) {
  Player player = e.getPlayer();
  ItemStack[] itemStacks = player.getInventory().getContents();
  Arrays.stream(itemStacks)
      .filter(item -> !Objects.isNull(item) && item.getMaxStackSize() == 64 && item.getAmount() < 64)
      .forEach(item -> item.setAmount(64));

  player.getInventory().setContents(itemStacks);//最初のコミット


}


}