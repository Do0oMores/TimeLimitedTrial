package top.mores.timeLimitedTrial.FileUtils;

import org.bukkit.configuration.file.FileConfiguration;
import top.mores.timeLimitedTrial.TimeLimitedTrial;

public class ConfigUtil {

    private FileConfiguration getConfig(){
        return TimeLimitedTrial.getInstance().getConfigFile();
    }
}
