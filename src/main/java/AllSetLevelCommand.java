import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class AllSetLevelCommand implements CommandExecutor {

  @Override
  public boolean onCommand( CommandSender Sender,  Command command, @NotNull String label, @NotNull String[] args) {
    if (sender instanceof Player player){
      
    }
    return false;
  }
}
