package bg.nikgmz.tutorialmod.item;

import bg.nikgmz.tutorialmod.TutorialMod;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup MOD_GROUP = Registry.register(Registries.ITEM_GROUP, new Identifier(TutorialMod.MOD_ID, "uranium"),
            FabricItemGroup.builder().displayName(Text.translatable("Tutorial Mod"))
                    .icon(() -> new ItemStack(ModItems.ICON_GROUP_ITEM)).entries((displayContext, entries) -> {
                        entries.add(ModItems.URANIUM);
                        entries.add(ModItems.THORIUM);
                    }).build());
    public static void registerItemGorups() {
        TutorialMod.LOGGER.info("Registering Item Groups" + TutorialMod.MOD_ID);
    }
}
