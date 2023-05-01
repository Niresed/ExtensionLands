package me.niresed.extensionlands.Main;

import me.niresed.extensionlands.Commands.AddFlag;
import me.niresed.extensionlands.Listeners.BlockPlaced;
import me.niresed.extensionlands.Listeners.FlagRaised;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

/*
Что осталось:
1. Изменить сам флаг, а то чёрный такое се
2. Удалять флаг после его поставки
3. Дать цену флагу при покупки (ресурсы)
4. Покупать флаг через интерфейс Lands если не получится то добавить крафт
5. Выводить проблемы игроку или в консоль (например если игрок поставил флаг не
6. Мелочи
7. Добавить какую то анимацию при покупки чанка (оригинальный от Lands не работает через Lands.claimChunk())
8. Сделать код по лучше, компактнее, добавить комментарии, мб джава док и дать нормальное название некоторым методам/переменным
 */
public final class ExtensionLands extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(new BlockPlaced(), this);
        getServer().getPluginManager().registerEvents(new FlagRaised(), this);
        Objects.requireNonNull(getCommand("AddFlag")).setExecutor(new AddFlag());

    }
}
