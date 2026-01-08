package top.mores.timeLimitedTrial;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import top.mores.timeLimitedTrial.CommandUtils.MainCommand;

import java.io.File;
import java.util.Objects;

public final class TimeLimitedTrial extends JavaPlugin {
    private static TimeLimitedTrial instance;
    private FileConfiguration config;
    private File configFile;

    @Override
    public void onEnable() {
        instance = this;
        initFiles();

        Objects.requireNonNull(getCommand("timelimit")).setExecutor(new MainCommand());
        getLogger().info("TimeLimitedTrial has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("TimeLimitedTrial has been disabled!");
    }

    public static TimeLimitedTrial getInstance() {
        return instance;
    }

    public void reloadConfigFile(){
        config= YamlConfiguration.loadConfiguration(configFile);
    }

    public @NotNull FileConfiguration getConfigFile() {
        if (config == null) {
            reloadConfigFile();
        }
        return config;
    }

    private void initFiles() {
        configFile = new File(getDataFolder(), "config.yml");
        if (!configFile.exists()) {
            boolean isCreateDir = configFile.getParentFile().mkdirs();
            if (!isCreateDir) {
                getLogger().warning("创建config.yml目录失败");
                return;
            }
            saveResource("config.yml", false);
        }
        reloadConfigFile();
    }
}
