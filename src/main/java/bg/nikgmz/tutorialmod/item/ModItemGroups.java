package bg.nikgmz.tutorialmod.item;

import bg.nikgmz.tutorialmod.TutorialMod;
import bg.nikgmz.tutorialmod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup MOD_GROUP = Registry.register(Registries.ITEM_GROUP, new Identifier(TutorialMod.MOD_ID, "mod"),
            FabricItemGroup.builder().displayName(Text.translatable("Tutorial Mod"))
                    .icon(() -> new ItemStack(ModItems.ICON_GROUP_ITEM)).entries((displayContext, entries) -> {


                        entries.add(ModItems.URANIUM);
                        entries.add(ModItems.THORIUM);
                        entries.add(ModItems.RAW_THORIUM);
                        entries.add(ModItems.RAW_URANIUM);

                        entries.add(ModBlocks.THORIUM_BLOCK);
                        entries.add(ModBlocks.RAW_THORIUM_BLOCK);
                        entries.add(ModBlocks.URANIUM_BLOCK);
                        entries.add(ModBlocks.RAW_URANIUM_BLOCK);

                        entries.add(ModBlocks.URANIUM_ORE);
                        entries.add(ModBlocks.DEEPSLATE_URANIUM_ORE);
                        entries.add(ModBlocks.THORIUM_ORE);
                        entries.add(ModBlocks.DEEPSLATE_THORIUM_ORE);

                    }).build());
    public static void registerItemGorups() {
        TutorialMod.LOGGER.info("Registering Item Groups" + TutorialMod.MOD_ID);
    }
}
